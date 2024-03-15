import {useContext, useState} from "react";
import {login} from '../../services/AuthService.js'
import AuthContext from "../context/AuthContext.jsx";
import {useNavigate} from "react-router-dom";

export const LoginComponent = () => {
    const { setAuthenticated } = useContext(AuthContext);

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);

    const navigate = useNavigate();

    const handleSubmit = async () => {
        event.preventDefault();
        try {
            // await login(username, password)
            const response = await login(username, password)

            const user = response.data.username
            const authorities = response.data.authorities

            setAuthenticated({user, authorities})
            navigate("/", {replace: true})
        } catch (e) {
            setError('Invalid username or password: ' + e.message)
        }
    }

    return (
        <>
            <div className="untree_co-hero inner-page overlay "
                 style={{backgroundImage: `url('images/img-school-5-min.jpg')`}}>
                <div className="container">
                    <div className="row align-items-center justify-content-center">
                        <div className="col-12">
                            <div className="row justify-content-center ">
                                <div className="col-lg-6 text-center ">
                                    <h1 className="mb-4 heading text-white" data-aos="fade-up"
                                        data-aos-delay="100">Login</h1>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div className="untree_co-section mt-5">
                <div className="container">
                    <div className="row mb-5 justify-content-center">
                        <div className="col-lg-5 mx-auto order-1" data-aos="fade-up" data-aos-delay="200">
                            <form onSubmit={handleSubmit} className="form-box">
                                <div className="row">
                                    <div className="col-12 mb-3">
                                        <input name="username" type="text" className="form-control" placeholder="UserName" value={username} onChange={(e) => setUsername(e.target.value)}/>
                                    </div>
                                    <div className="col-12 mb-3">
                                        <input name="password" type="password" className="form-control" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)}/>
                                    </div>

                                    <div className="col-12 mb-3">
                                        <label className="control control--checkbox">
                                            <span className="caption">Remember me</span>
                                            <input type="checkbox" checked="checked"/>
                                            <div className="control__indicator"></div>
                                        </label>
                                    </div>

                                    <div className="col-12">
                                        <input type="submit" value="Send Message" className="btn btn-primary"/>
                                    </div>

                                    {error && <div className="col-12 mt-3 text-danger">{error}</div>}
                                </div>
                            </form>
                        </div>
                    </div>


                </div>
            </div>
        </>
    )
}