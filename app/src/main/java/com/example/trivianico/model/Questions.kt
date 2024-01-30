package com.example.trivianico.model

data class Questions(
    val question: String,
    val correctOption: String,
    val incorrectOption1: String,
    val incorrectOption2: String,
    val incorrectOption3: String,
    val category: Category,
    val diff: Diff,
)

enum class Category {
    Geografia,
    Arte,
    Historia,
    Entretenimiento,
    Ciencias,
    Deportes
}

enum class Diff {
    Easy,
    Normal,
    Hard
}


val questionsList: List<Questions> = listOf(

    //Historia------------------------------------------

    Questions(
        "¿Quién fue el primer presidente de la democracia española tras el franquismo?",
        "Adolfo Suárez",
        "Isabel Díaz Ayuso",
        "Perro Sanxe",
        "Leopoldo Calvo Sotelo",
        Category.Historia,
        Diff.Easy
    ),
    Questions(
        "¿En qué año el hombre pisó la Luna por primera vez?",
        "1969",
        "1968",
        "1967",
        "Nunca",
        Category.Historia,
        Diff.Easy
    ),
    Questions(
        "¿Quién fue el primer presidente de Estados Unidos?",
        "George Washington",
        "Bill Russel",
        "Barack Obama",
        "Franklin D. Roosevelt",
        Category.Historia,
        Diff.Easy
    ),
    Questions(
        "¿Qué carabela no volvió del viaje en el que Colón arribó a América por primera vez?",
        "Santa María",
        "Niña",
        "Pinta",
        "Going Merry",
        Category.Historia,
        Diff.Easy
    ),
    Questions(
        "¿Quiénes fueron, según la leyenda, los dos hermanos fundadores de la ciudad de Roma?",
        "Rómulo y Remo",
        "Rémulo y Rome",
        "Roma y Remo",
        "Rómulo y Roma",
        Category.Historia,
        Diff.Easy
    ),
    Questions(
        "¿La invasión de qué fortaleza por parte de los revolucionarios es considerada como el punto de inicio de la Revolución Francesa?",
        "La toma de la Bastilla",
        "Desembarco de Normandía",
        "Las guerras Napoléonicas",
        "El desembarco del Rey",
        Category.Historia,
        Diff.Normal
    ),
    Questions(
        "¿Cuánto duró la Guerra de los Cien Años?",
        "116 años",
        "100 años",
        "99 años",
        "117 años",
        Category.Historia,
        Diff.Normal
    ),
    Questions(
        "¿En qué año se creó la Organización de las Naciones Unidas?",
        "1945",
        "1942",
        "1950",
        "1955",
        Category.Historia,
        Diff.Normal
    ),
    Questions(
        "¿Cómo se apellidaban los dos exploradores que dieron la primera vuelta al mundo?",
        "Magallanes-Elcano",
        "Marco-Polo",
        "Elcano-Colón",
        "Magallanes-Polo ",
        Category.Historia,
        Diff.Normal
    ),
    Questions(
        "¿Quién era el gran ministro británico cuando la India Británica fue sacudida por la hambruna de Bengala?",
        "Winston Churchill",
        "Margaret Thatcher",
        "Sir Anthony Eden",
        "Boris Johnson",
        Category.Historia,
        Diff.Normal
    ),
    Questions(
        "¿Cuál es la narración épica más antigua de la historia, encontrada en tablillas de arcilla sobre las que se usó escritura cuneiforme?",
        "Epopeya de Gilgamesh",
        "La Santa Biblia",
        "La Divina Comedia",
        "El cantar del Mio Cid",
        Category.Historia,
        Diff.Normal
    ),
    Questions(
        "¿Qué faraón egipcio es conocido por haber intentado que su imperio pasase del politeísmo al monoteísmo a través del culto al dios Atón?",
        "Akenatón",
        "Ramsés II",
        "Cleopatra",
        "Anedjib",
        Category.Historia,
        Diff.Hard
    ),
    Questions(
        " ¿Qué emperador romano es conocido entre otras cosas por haber intentado someterse a operaciones de cambio de sexo?",
        "Marco Aurelio Antonino Augusto",
        "Tiberius Iulius Caesar",
        "Marcus Opellius Macrinus",
        "Lucius Septimius Severus",
        Category.Historia,
        Diff.Hard
    ),
    Questions(
        " ¿En qué idioma están escritos los manuscritos más antiguos pertenecientes a la parte de la Biblia que hoy conocemos como Nuevo Testamento?",
        "Griego antiguo",
        "Hebreo antiguo",
        "Latin",
        "Celta",
        Category.Historia,
        Diff.Hard
    ),
    Questions(
        "¿Cuándo se inventó la escritura?",
        "En el IV milenio a.C",
        "Hace 20 mil años",
        "En el año 0",
        "Hace 37854 años",
        Category.Historia,
        Diff.Hard
    ),
    Questions(
        "¿Contra quiénes se enfrentaron los griegos en las Guerras Médicas del siglo V a.C.?",
        "Los persas",
        "Los celtas",
        "Los hebreos",
        "Los hunos",
        Category.Historia,
        Diff.Hard
    ),


    //Arte--------------------------------------

    Questions(
        "¿Quién escribió la Ilíada y la Odisea?",
        "Homero",
        "Bart",
        "Maggie",
        "Lisa",
        Category.Arte,
        Diff.Easy
    ),
    Questions(
        "¿Quién pintó el “Guernica”?",
        "Picasso",
        "Velazquez",
        "Goya",
        "Zurbarán",
        Category.Arte,
        Diff.Easy
    ),
    Questions(
        "¿De qué estilo arquitectónico es la catedral de Notre Dame?",
        "Gótico",
        "Barroco",
        "Renacentista",
        "Románico",
        Category.Arte,
        Diff.Easy
    ),
    Questions(
        "¿Qué nombre tenía el caballo de Don Quijote de la Mancha?",
        "Rocinante",
        "Blanco",
        "Roach",
        "Sardinilla",
        Category.Arte,
        Diff.Easy
    ),
    Questions(
        "¿Qué nombre tenía el caballo de Don Quijote de la Mancha?",
        "Rocinante",
        "Blanco",
        "Roach",
        "Sardinilla",
        Category.Arte,
        Diff.Easy
    ),



    //Geografía

    Questions(
        "¿Cuál es el río más caudaloso del mundo?",
        "Amazonas",
        "Nilo",
        "Tajo",
        "Mississipí",
        Category.Geografia,
        Diff.Easy
    ),
    Questions(
        "¿Cuál es el monte más alto del mundo?",
        "Everest",
        "Teide",
        "Kanchenjunga",
        "Manaslu",
        Category.Geografia,
        Diff.Easy
    ),
    Questions(
        "¿Cómo se llama la línea vertical imaginaria a partir del cual se miden las longitudes y que divide el mundo en dos mitades?",
        "Meridiano de Greenwich",
        "Línea del Ecuador",
        "Norte",
        "Sur",
        Category.Geografia,
        Diff.Easy
    ),
    Questions(
        "¿Cuál es la capital de Canadá?",
        "Ottawa",
        "Vancouver",
        "Toronto",
        "Mont-real",
        Category.Geografia,
        Diff.Easy
    ),
    Questions(
        "¿Dónde podemos encontrar la Casa Rosada?",
        "Argentina",
        "EEUU",
        "Colombia",
        "Mexico",
        Category.Geografia,
        Diff.Easy
    ),
    Questions(
        "¿Cúantas comunidades autónomas hay en España?",
        "17",
        "16",
        "18",
        "20",
        Category.Geografia,
        Diff.Normal
    ),
    Questions(
        "¿Cuál es el país de mayor tamaño del mundo?",
        "Rusia",
        "China",
        "Brasil",
        "Vaticano",
        Category.Geografia,
        Diff.Normal
    ),
    Questions(
        "¿Cuál es la capital de Filipinas?",
        "Manila",
        "Bangkok",
        "Pekin",
        "Filipinas DC",
        Category.Geografia,
        Diff.Normal
    ),
    Questions(
        "¿Cuál es el país europeo del que provienen las familias de la mayor parte de los habitantes de Argentina?",
        "Italia",
        "España",
        "Portugal",
        "Francia",
        Category.Geografia,
        Diff.Normal
    ),
    Questions(
        "¿Cuál es la capital de Nueva Zelanda?",
        "Aukland",
        "Sydney",
        "Queenstown",
        "Wellington",
        Category.Geografia,
        Diff.Normal
    ),
    Questions(
        "¿Cuántos estados forman parte de Estados Unidos?",
        "50",
        "54",
        "33",
        "51",
        Category.Geografia,
        Diff.Hard
    ),
    Questions(
        "¿En qué país hay un mayor número de pirámides?",
        "Sudán",
        "Egipto",
        "Marruecos",
        "Sudafrica",
        Category.Geografia,
        Diff.Hard
    ),
    Questions(
        "¿Cuál es la cordillera de montañas más larga del mundo?",
        "Los Andes",
        "Himalaya",
        "Montañas Rocosas",
        "De la Costa",
        Category.Geografia,
        Diff.Hard
    ),
    Questions(
        "¿Cuál es la ciudad más fría del mundo?",
        "Oymyakon (Rusia)",
        "Siberia (Rusia)",
        "Harbin (China)",
        "Winnipeg (Canadá)",
        Category.Geografia,
        Diff.Hard
    ),
    Questions(
        " ¿Qué continente se encuentra en los 4 hemisferios?",
        "Africa",
        "América",
        "Europa",
        "Oceanía",
        Category.Geografia,
        Diff.Hard
    ),


)