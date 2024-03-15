import {createContext, useRef, useState} from 'react';

const AuthContext = createContext({});

export const AuthProvider = ({children}) => {
    const [authenticated, setAuthenticated] = useState({});

    return (
        <AuthContext.Provider value={{authenticated, setAuthenticated}}>
            {children}
        </AuthContext.Provider>
    );
};

export default AuthContext