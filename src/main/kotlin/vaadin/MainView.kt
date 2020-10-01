package vaadin

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.page.AppShellConfigurator
import com.vaadin.flow.component.textfield.IntegerField
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.PWA

data class Person(val nama: String, val usia: Int, val pekerjaan: String){
    override fun toString(): String {
        return nama+" usia "+usia
    }
}
@Route("")
@CssImport.Container(value = [  // repeatable annotations are not supported by Kotlin, please vote for https://youtrack.jetbrains.com/issue/KT-12794
    CssImport("./styles/shared-styles.css"),
    CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
])
class MainView : KComposite() {
    private lateinit var nameField: TextField
    private lateinit var usiaField: IntegerField
    private lateinit var pekerjaanField:  TextField
    private lateinit var addButton: Button
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button
    private lateinit var allPersonButton: Button
    private lateinit var listPerson:Grid<Person>
    // The main view UI definition
    private val root = ui {
        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        verticalLayout(isPadding = true) {
            horizontalLayout(isPadding = true, true) {
                nameField = textField("Nama")
                usiaField = integerField("Usia")
                pekerjaanField = textField("Pekerjaan")
            }
            horizontalLayout(isPadding = true, isSpacing = true) {
                addButton=button("Add")
                updateButton=button("Update")
                deleteButton=button("Delete")
                allPersonButton=button("All person")
            }
            listPerson=grid(){
                this.setColumns("nama","usia","pekerjaan")
            }
        }
    }
    init {

        addButton.onLeftClick {
            addPressed(mutableMapOf("nama" to nameField.value, "usia" to usiaField.value.toString(), "pekerjaan" to pekerjaanField.value))
            Notification.show(nameField.value + " added!")
        }
        updateButton.onLeftClick {
            updatePressed(mutableMapOf("nama" to nameField.value, "usia" to usiaField.value.toString(), "pekerjaan" to pekerjaanField.value))
            Notification.show(nameField.value + " updated")
        }
        deleteButton.onLeftClick {
            deletePressed(mutableMapOf("nama" to nameField.value))
            Notification.show(nameField.value + " deleted")
        }
        allPersonButton.onLeftClick {
            val allp=allPersonPressed()
            listPerson.setItems(allp)
        }

    }
}

@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
class AppShell: AppShellConfigurator
