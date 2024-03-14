import {NavbarComponent} from "../components/NavbarComponent.jsx";
import {HeroComponent} from "../components/home/HeroComponent.jsx";
import {FooterComponent} from "../components/FooterComponent.jsx";
import {LoaderComponent} from "../components/LoaderComponent.jsx";
import {CategoryComponent} from "../components/home/CategoryComponent.jsx";
import {ServicesSectionComponent} from "../components/home/ServicesSectionComponent.jsx";
import {EducationComponent} from "../components/home/EducationComponent.jsx";
import {CoursePriceComponent} from "../components/home/CoursePriceComponent.jsx";
import {MotivationComponent} from "../components/home/MotivationComponent.jsx";
import {AboutUsComponent} from "../components/home/AboutUsComponent.jsx";
import {FeedBackComponent} from "../components/home/FeedBackComponent.jsx";
import {ChooseUsComponent} from "../components/home/ChooseUsComponent.jsx";

export const HomePage = () => {
    return (
        <>
            <NavbarComponent />
            <HeroComponent />
            <CategoryComponent />
            <ServicesSectionComponent />
            <EducationComponent />
            <CoursePriceComponent />
            <MotivationComponent />
            <AboutUsComponent />
            <FeedBackComponent />
            <ChooseUsComponent />
            <FooterComponent />
            <LoaderComponent />
        </>
    )
}