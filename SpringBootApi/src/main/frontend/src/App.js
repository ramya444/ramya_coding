import React from 'react';
class App extends React.Component {
    constructor(props) {

        super(props);

        this.state = {
            items: [],
            isLoaded: false
        }

    }

    componentDidMount() {

        fetch('http://localhost:8080/get',{mode:'no-cors'})
            .then(res => res.json())
            .then(json => {
                this.setState({
                    items: json,
                    isLoaded: true, 
                })
            }).catch((err) => {
                console.log(err);
            });

    } 
    render() {

       return (
           <div>
       </div>
       );
}
}

export default App;