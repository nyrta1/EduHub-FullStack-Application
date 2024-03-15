import {NavbarComponent} from "./NavbarComponent.jsx";
import {FooterComponent} from "./FooterComponent.jsx";

// eslint-disable-next-line react/prop-types
export const Layout = ({ children }) => {
    return (
        <>
            <NavbarComponent />
                {children}
            <FooterComponent />
        </>
    );
};