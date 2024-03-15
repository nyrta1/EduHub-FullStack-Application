import { useState } from 'react';
import {register} from "../../services/AuthService.js";

export const RegisterComponent = () => {
    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            await register(name, surname, username, password);
        } catch (error) {
            console.error('Registration failed:', error.message);
            setError('Registration failed:'+ error.message)
        }
    };

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
                                        <input name="name" type="text" className="form-control" placeholder="Name"
                                               value={name} onChange={(e) => setName(e.target.value)}/>
                                    </div>
                                    <div className="col-12 mb-3">
                                    <input name="surname" type="text" className="form-control" placeholder="Surname"
                                           value={surname} onChange={(e) => setSurname(e.target.value)}/>
                                    </div>
                                    <div className="col-12 mb-3">
                                        <input name="username" type="text" className="form-control" placeholder="Username"
                                               value={username} onChange={(e) => setUsername(e.target.value)}/>
                                    </div>
                                    <div className="col-12 mb-3">
                                        <input name="password" type="password" className="form-control" placeholder="Password"
                                               value={password} onChange={(e) => setPassword(e.target.value)}/>
                                    </div>
                                    <div className="col-12">
                                        <input type="submit" value="Register" className="btn btn-primary"/>
                                    </div>
                                    {error && <div className="col-12 mt-3 text-danger">{error}</div>}
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};