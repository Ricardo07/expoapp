package expoapp

import pl.touk.excel.export.WebXlsxExporter

class EstudianteController {

    //static scaffold = true
    def index() {
        redirect(action: 'formulario')
    }


    def formulario(){

    }

    def registrarEstudiante(){
        Estudiante estudiante = new Estudiante(params)

        if(estudiante.validate()){
            estudiante.save()
            redirect( action: 'registrado')
        }else{
//            render "No se pudo registrar.(implementacion pendiente)"
            redirect(action: 'formulario', model:[estudiante:estudiante])
        }


        println(params)
    }

    def registrado(){

    }

    def mostrarestudiantes(){
        def lista = Estudiante.findAll()
        render(lista)
    }

    def elegirEstudianteAleatorio(){
        //Aqui es donde se escojera un estudiante aleatorio para ganar el sorteo.
        def listaEstudiantes =  Estudiante.findAll()
        //TODO: implementacion pendiente
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
