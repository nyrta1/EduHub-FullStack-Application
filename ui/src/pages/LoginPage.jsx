import {NavbarComponent} from "../components/NavbarComponent.jsx";
import {LoginComponent} from "../components/auth/LoginComponent.jsx";
import {FooterComponent} from "../components/FooterComponent.jsx";

export const LoginPage = () => {
    return (
        <>
            <NavbarComponent />
            <LoginComponent />
            <FooterComponent />
        </>
    )
}