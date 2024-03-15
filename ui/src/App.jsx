// Import React DOMs
import {Route, Routes} from "react-router-dom";
import {HomePage} from "./pages/HomePage.jsx";
import {LoginPage} from "./pages/LoginPage.jsx";
import {RegisterPage} from "./pages/RegisterPage.jsx";

export default function App() {

  return (
    <>
      <Routes>
          <Route path="/" element={<HomePage />}></Route>
          <Route path="/auth/login" element={<LoginPage />}></Route>
          <Route path="/auth/register" element={<RegisterPage />}></Route>
      </Routes>
    </>
  )
}