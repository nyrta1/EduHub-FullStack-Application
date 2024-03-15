import {createContext, useRef, useState} from 'react';

export const AuthContext = createContext(undefined);

// eslint-disable-next-line react/prop-types
export const AuthProvider = ({children}) => {
    const [authenticated, setAuthenticated] = useState(false);
    const isAuthenticatedRef = useRef(false);
    isAuthenticatedRef.current = authenticated;

    alert(authenticated)

    const setAsLoggedIn = () => {
        setAuthenticated(true);
    };

    const setAsLoggedOut = () => {
        setAuthenticated(false);
    };

    return (
        <AuthContext.Provider value={{isAuthenticatedRef, setAsLoggedIn, setAsLoggedOut}}>
            {children}
        </AuthContext.Provider>
    );
};