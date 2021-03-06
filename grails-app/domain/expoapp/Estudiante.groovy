package expoapp

class Estudiante {

    String nombre//
    String apellido//
    String email//
    String celular//
    String colegio
    String opcion_carrera1
    String opcion_carrera2
    String opcion_carrera3
    String twitter


//    Estudiante(name, last_name, email, cell, school, option1, option2, option3, twitter){
//        this.nombre = name
//        this.apellido = last_name
//        this.email = email
//        this.celular = cell
//        this.colegio = school
//        this.opcion_carrera1 = option1
//        this.opcion_carrera2 = option2
//        this.opcion_carrera3 = option3
//        this.twitter = twitter
//    }

    static constraints = {
        nombre minSize: 3, nullable: false
        apellido minSize: 3, nullable: false
        email email: true, unique: true, nullable: false
        celular minSize: 10, unique: true, nullable: true
        colegio minSize: 3, nullable: false
        opcion_carrera1 nullable: false, inList: ["Administración de Empresas",
                "Administración Hotelera",
                "Arquitectura",
                "Comunicación Social",
                "Derecho",
                "Ecología y Gestión Ambiental",
                "Economía",
                "Educación Básica",
                "Enfermería",
                "Estomatología",
                "Filosofía",
                "Gestión Financiera y Auditoría",
                "Ingeniería Civil",
                "Ingeniería Electromecánica",
                "Ingeniería Electrónica",
                "Ingeniería Industrial",
                "Ingeniería de Sistemas y Computación",
                "Ingeniería Telemática",
                "Medicina",
                "Mercadotecnia",
                "Psicología",
                "Terapia Física",
                "Nutrición y Dietética"
        ]
        opcion_carrera2 nullable: true, inList: ["Administración de Empresas",
                "Administración Hotelera",
                "Arquitectura",
                "Comunicación Social",
                "Derecho",
                "Ecología y Gestión Ambiental",
                "Economía",
                "Educación Básica",
                "Enfermería",
                "Estomatología",
                "Filosofía",
                "Gestión Financiera y Auditoría",
                "Ingeniería Civil",
                "Ingeniería Electromecánica",
                "Ingeniería Electrónica",
                "Ingeniería Industrial",
                "Ingeniería de Sistemas y Computación",
                "Ingeniería Telemática",
                "Medicina",
                "Mercadotecnia",
                "Psicología",
                "Terapia Física",
                "Nutrición y Dietética"]
        opcion_carrera3 nullable: true, minSize: 2
        twitter nullable: true
    }
}
