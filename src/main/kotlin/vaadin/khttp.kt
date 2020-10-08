package vaadin
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vaadin.flow.component.notification.Notification
import khttp.*

fun addPressed(a:MutableMap<String,String>){
    var radd= post("http://localhost:9000/addPerson",json = a)
}
fun updatePressed(a:MutableMap<String,String>){
    var rup= get("http://localhost:9000/updatePerson",params = a)
}
fun allPersonPressed(): MutableList<Person> {
    var rall=get("http://localhost:9000/allPerson")
    val g= Gson()
    val listPersonType = object : TypeToken<MutableList<Person>>() {}.type
    var persons: MutableList<Person> = g.fromJson(rall.text, listPersonType)
    return persons
}
fun deletePressed(a:MutableMap<String,String>){
    var rdel=get("http://localhost:9000/deletePerson",params = a)
}
fun deleteMultiPressed(a:MutableSet<Person>){
    for (i in a){
        var mapnya= mutableMapOf("nama" to i.nama)
        var rdelmulti=get("http://localhost:9000/deletePerson",params=mapnya)
    }
}
