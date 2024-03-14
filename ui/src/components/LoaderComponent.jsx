export const LoaderComponent = () => {
    return (
        <div>
            <div id="overlayer"></div>
            <div className="loader">
                <div className="spinner-border" role="status">
                    <span className="sr-only">Loading...</span>
                </div>
            </div>
        </div>
    );
}