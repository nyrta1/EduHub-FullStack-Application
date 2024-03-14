import {NavbarComponent} from "../components/NavbarComponent.jsx";
import {RegisterComponent} from "../components/auth/RegisterComponent.jsx";
import {FooterComponent} from "../components/FooterComponent.jsx";

export const RegisterPage = () => {
    return (
        <>
            <NavbarComponent />
            <RegisterComponent />
            <FooterComponent />
        </>
    )
}