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
            redirect(action: 'formulario')
        }else{
            render "No se pudo registrar.(implementacion pendiente)"
        }


        println(params)
    }

    def elegirEstudianteAleatorio(){
        //Aqui es donde se escojera un estudiante aleatorio para ganar el sorteo.
        def listaEstudiantes =  Estudiante.findAll()
        //TODO: implementacion pendiente
    }


    def exportToExcel(){
        //aqui se implementara la exportacion a excel de la lista de estudiantes.\
        /*
        Para Probar funcionalidad
        List<Estudiante> lista = []

        lista.add(new Estudiante("Ross","Logan","auctor.ullamcorper.nisl@etultricesposuere.co.uk","(810) 963-2288","Quisque Libero Lacus Corporation","Estomatología","Derecho","et rutrum","Velez"))
        lista.add(new Estudiante("Zelenia","Fischer","sed.libero@ornareelitelit.edu","(215) 203-2025","Sollicitudin Foundation","Economía","Filosofía","sapienAenean","Tyson"))
        lista.add(new Estudiante("John","Padilla","metus.eu@inlobortis.co.uk","(379) 923-7351","Enim Incorporated","Administración de Empresas","Derecho","Cum sociis","Gill"))
        lista.add(new Estudiante("Briar","Carver","aliquam.eros.turpis@eleifend.org","(909) 268-4605","Massa Lobortis LLP","Arquitectura","Medicina","sed dictum","Hammond"))
        */
        def Estudiantes = Estudiante.findAll()

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
