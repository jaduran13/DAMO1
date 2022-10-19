package ni.edu.uca.practica1910.personas



class ListPersona (val lista:ArrayList<Persona>){

    fun agregar(nom:String, ape:String, edad:Int){
        lista.add(Persona(nom, ape, edad))
    }


}