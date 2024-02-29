import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aplicacion.Presentation.viewModel.ContactFormViewModel
import com.example.aplicacion.data.model.Contact

@Composable
fun ContactFormScreen(viewModel: ContactFormViewModel) {
    val nameState = remember { mutableStateOf("") }
    val phoneNumberState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Add New Contact",
            style = MaterialTheme.typography.bodyMedium
        )
        Divider()
        ContactForm(
            nameState = nameState,
            phoneNumberState = phoneNumberState,
            emailState = emailState,
            onSaveClicked = { name, phoneNumber, email ->
                val contact = Contact(
                    id = 0,
                    name = name,
                    phoneNumber = phoneNumber,
                    email = email
                )
                viewModel.saveContact(contact = contact)
            },
            onCancelClicked = {

                nameState.value = ""
                phoneNumberState.value = ""
                emailState.value = ""
            }
        )
    }
}


@Composable
fun ContactForm(
    nameState: MutableState<String>,
    phoneNumberState: MutableState<String>,
    emailState: MutableState<String>,
    onSaveClicked: (String, String, String) -> Unit,
    onCancelClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = nameState.value,
            onValueChange = { nameState.value = it },
            label = { Text("Name") }
        )

        OutlinedTextField(
            value = phoneNumberState.value,
            onValueChange = { phoneNumberState.value = it },
            label = { Text("Phone Number") }
        )

        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email") }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { onSaveClicked(nameState.value, phoneNumberState.value, emailState.value) }) {
                Text(text = "Save")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { onCancelClicked() }) {
                Text(text = "Cancel")
            }
        }
    }
}


