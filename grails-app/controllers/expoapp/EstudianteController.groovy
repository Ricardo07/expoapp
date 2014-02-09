package expoapp

import pl.touk.excel.export.WebXlsxExporter
import java.util.Random

class EstudianteController {

    List<Estudiante> lista_ganadores_pasados = new LinkedList<>()
    Estudiante ganador_pasado
    int contador_ganadores = 0

    //static scaffold = true
    def index() {
        redirect(action: 'formulario')
    }

    def formulario(){
        //Se desplega la vista formulario
    }

    def registrarEstudiante(){
        Estudiante estudiante = new Estudiante(params)

        if(estudiante.validate()){
            estudiante.save()
            redirect( action: 'registrado')
        }else{

            //TODO:implementar errores
            println estudiante.errors.fieldErrors
            redirect(action: 'formulario', model:[estudiante:estudiante])
        }
    }

    def registrado(){

    }

    def mostrarestudiantes(){
        def lista = Estudiante.findAll()
        render(lista)
    }

    def elegirestudiantealeatorio(){

        //Aqui es donde se escojera un estudiante aleatorio para ganar el sorteo.
        Random random = new Random()
        List<Estudiante> lista_estudiantes = Estudiante.findAll()
        int tamanio = lista_estudiantes.size()

        //Verifica si por lo menos existe un estudiante en registrado
        if(tamanio > 0){

            //Agregar agregar el ganador pasado a su respectiva lista
            //La primera vez no hay ganador pasado, por lo que no se insertará nada en la lista
            if(ganador_pasado){
                lista_ganadores_pasados.add(ganador_pasado)
            }

            //Seleccionar aleatoriamente un nuevo ganador
            Estudiante ganador = lista_estudiantes.get(random.nextInt(tamanio))

            //Despuest de seleccionarlo, debe ser marcado para saber en la próxima iteracion quien fue el ganador pasado pasado
            ganador_pasado = ganador


            contador_ganadores++
            //La primera vez solo puede haber un ganador, por lo que no debe haber ganadores pasados
            //ya cuando es mayor que 1 pues hay que despreglar la lista de los de los ganadores pasados
            if(contador_ganadores > 1){
                return [nombre:ganador.nombre,apellido:ganador.apellido,colegio:ganador.colegio,celular:ganador.celular,lista:lista_ganadores_pasados]
            }else{
                return [nombre:ganador.nombre,apellido:ganador.apellido,colegio:ganador.colegio,celular:ganador.celular]
            }

        }else{
            return [mensaje:"No se han registrados los estudiantes."]
        }
    }


    def exportToExcel(){
        //aqui se implementara la exportacion a excel de la lista de estudiantes.\
        def Estudiantes = Estudiante.listOrderByOpcion_carrera1()

        def headers = ['Nombre', 'Apellido', 'Email', 'Celular', 'Colegio', 'Opcion Carrera 1', 'Opcion Carrera 2', 'Opcion Carrera 3', 'Twitter']
        def withProperties = ['nombre', 'apellido', 'email', 'celular', 'colegio', 'opcion_carrera1', 'opcion_carrera2', 'opcion_carrera3', 'twitter']

        //Mediante WebXLSReporter(Downloadable via controller)
        //De este modo el archivo se descargara desde el browser
        new WebXlsxExporter().with{
            setResponseHeaders(response)
            fillHeader(headers)
            add(Estudiantes, withProperties)
            save(response.outputStream)
        }

        //TODO: controlar manejo de errores

    }
}
