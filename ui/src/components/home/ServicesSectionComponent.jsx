export const ServicesSectionComponent = () => {
    return (
        <>
            <div className="services-section">
                <div className="container">
                    <div className="row justify-content-between">
                        <div className="col-lg-4 mb-5 mb-lg-0">

                            <div className="section-title mb-3" data-aos="fade-up" data-aos-delay="0">
                                <h2 className="line-bottom mb-4">Become an Instructor</h2>
                            </div>

                            <p data-aos="fade-up" data-aos-delay="100">Far far away, behind the word mountains, far from
                                the countries Vokalia and Consonantia, there live the blind texts. Separated they
                                live.</p>

                            <ul className="ul-check list-unstyled mb-5 primary" data-aos="fade-up" data-aos-delay="200">
                                <li>Behind the word Mountains.</li>
                                <li>Far far away Mountains.</li>
                                <li>Large language Ocean.</li>
                            </ul>

                            <p data-aos="fade-up" data-aos-delay="300"><a href="#" className="btn btn-primary">Get
                                Started</a></p>

                        </div>
                        <div className="col-lg-6" data-aos="fade-up" data-aos-delay="0">
                            <figure className="img-wrap-2">
                                <img src="/images/teacher-min.jpg" alt="Image" className="img-fluid"/>
                                <div className="dotted"></div>
                            </figure>

                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}