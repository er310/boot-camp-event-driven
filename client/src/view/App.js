import React from 'react';

import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import Grid from '@material-ui/core/Grid';
import Container from '@material-ui/core/Container';
import TextField from '@material-ui/core/TextField';

import {apiEndPoint} from 'config';

class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            costumeId: '',
            name: '',
            condition: '',
            submitted: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e) {
        const {name, value} = e.target;
        this.setState({[name]: value});
    }

    handleSubmit(e) {
        e.preventDefault();

        this.setState({submitted: true});

        const {costumeId, name, condition} = this.state;
        insert(costumeId, name, condition).then(r => console.log('done'));
    }

    render() {
        return (
            <React.Fragment>
                <CssBaseline/>
                <Container fixed>
                    <Grid container
                          direction="row"
                          justify="center"
                          alignItems="center"
                          spacing={3}>
                        <Grid item xs={6}>
                            <form
                                noValidate autoComplete="off"
                                onSubmit={this.handleSubmit}>
                                <TextField
                                    id="costume-id"
                                    label="Costume Reference No."
                                    value={this.state.costumeId}
                                    variant="filled"
                                />
                                <TextField
                                    id="name"
                                    label="Name"
                                    value={this.state.name}
                                    variant="filled"
                                />
                                <TextField
                                    id="condition"
                                    label="Condition"
                                    value={this.state.condition}
                                    variant="filled"
                                />
                                <Button variant="contained" color="primary">
                                    Submit
                                </Button>
                            </form>
                        </Grid>
                    </Grid>
                </Container>
            </React.Fragment>
        );
    }
}

function insert(costumeId, name, condition) {
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({costumeId, name, condition})
    };

    return fetch(`${apiEndPoint.apiUrl}/costumes`, requestOptions)
        .then(costume => {
            return costume;
        });
}

export default App;
