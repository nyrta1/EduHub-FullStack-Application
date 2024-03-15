import axios from 'axios';

export async function login(username, password) {
    // We use FormData because the login logic in Spring Boot expects form data.
    const formData = new FormData();
    formData.append('username', username);
    formData.append('password', password);

    try {
        return await axios.post('http://localhost:8080/auth/login', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            },
            withCredentials: true,
        });
    } catch (err) {
        console.error('Error occurred during login:', err);
        alert('Error occurred during login:'+ err)
        throw err;
    }
}

export async function register(name, surname, username, password) {
    try {
        const formData = {
            name: name,
            surname: surname,
            username: username,
            password: password
        };

        const jsonRegisterData = JSON.stringify(formData);

        const response = await axios.post('http://localhost:8080/auth/register', jsonRegisterData, {
           headers: {
               'Content-Type': 'application/json'
           },
           withCredentials: true,
        });

        if (response.status === 200) {
            // If the user authenticated successfully, then it will redirect to login page
            window.location.replace("http://localhost:5173/auth/login")
        }
    } catch (err) {
        console.error('Error occurred during registration:', err);
        throw err;
    }
}
