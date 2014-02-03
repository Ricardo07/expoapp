package expoapp

class EstudianteController {

    //static scaffold = true
    def index() {
        redirect(action: 'formulario')
    }


    def formulario(){

    }

    def registrarestudiante(){

        Estudiante estudiante = new Estudiante(params)

        if(estudiante.validate()){
            redirect(action: 'formulario')
        }else{
            render "No se puedo registrar.(implementacion pendiente)"
        }


        println(params)
    }
}
