import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.aplicacion.Presentation.theme.AplicacionTheme
import com.example.aplicacion.Presentation.viewModel.ContactFormViewModel
import com.example.aplicacion.Presentation.viewModel.ContactListViewModel
import com.example.aplicacion.data.repository.ContactRepositoryImpl
import com.example.aplicacion.data.model.Contact

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val filePath = "ruta/del/archivo/contactos.txt"
        val contactRepository = ContactRepositoryImpl(filePath)
        val viewModel = ContactListViewModel(contactRepository)

        setContent {
            AplicacionApp(contactRepository, viewModel)
        }
    }
}

@Composable
fun AplicacionApp(contactRepository: ContactRepositoryImpl, viewModel: ContactListViewModel) {
    AplicacionTheme {
        val navController = rememberNavController()

        NavHost(navController, startDestination = "contactList") {
            composable("contactList") {
                ContactListScreen(viewModel = ContactListViewModel(contactRepository))
            }
            composable("contactDetail/{contactId}") { backStackEntry ->
                val contactId = backStackEntry.arguments?.getString("contactId")?.toIntOrNull()
                val contact = contactId?.let { contactRepository.getContactById(it) }
                contact?.let { ContactDetailScreen(it) }
            }
            composable("contactForm") {
                ContactFormScreen(viewModel = ContactFormViewModel(contactRepository))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AplicacionApp(
        ContactRepositoryImpl("ruta/del/archivo/contactos.txt"),
        ContactListViewModel(ContactRepositoryImpl("ruta/del/archivo/contactos.txt"))
    )
}
