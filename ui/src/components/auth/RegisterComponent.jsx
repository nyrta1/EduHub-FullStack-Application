import { useState } from 'react';
import axios from 'axios';

export const RegisterComponent = () => {
    const [formData, setFormData] = useState({
        name: '',
        surname: '',
        username: '',
        password: ''
    });

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post('http://localhost:8080/auth/register', formData);
            console.log('Registration successful:', response.data);
        } catch (error) {
            console.error('Registration failed:', error);
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
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
                                        <input name="name" type="text" value={formData.name} onChange={handleChange}
                                               className="form-control" placeholder="Name"/>
                                    </div>
                                    <div className="col-12 mb-3">
                                    <input name="surname" type="text" value={formData.surname}
                                               onChange={handleChange} className="form-control" placeholder="Surname"/>
                                    </div>
                                    <div className="col-12 mb-3">
                                        <input name="username" type="text" value={formData.username}
                                               onChange={handleChange} className="form-control" placeholder="Username"/>
                                    </div>
                                    <div className="col-12 mb-3">
                                        <input name="password" type="password" value={formData.password}
                                               onChange={handleChange} className="form-control" placeholder="Password"/>
                                    </div>
                                    <div className="col-12">
                                        <input type="submit" value="Register" className="btn btn-primary"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};