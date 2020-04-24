import React from 'react';

import {Form, Field} from 'react-final-form';
import {TextField, Select} from 'final-form-material-ui';
import {
    Typography,
    Paper,
    Grid,
    Button,
    Container,
    CssBaseline,
    MenuItem
} from '@material-ui/core';

import {apiEndPoint} from 'config';

class App extends React.Component {
    constructor(props) {
        super(props);

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(values) {
        const {costumeId, name, condition} = values;
        insert(costumeId, name, condition).then(done => console.log('Completed: ' + done));
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
                          spacing={2}>
                        <Grid item xs={8}>
                            <Typography variant="h5" align="center" component="h2" gutterBottom>
                                BootCamp Event Driven Architecture Example
                            </Typography>
                        </Grid>
                        <Grid item xs={8}>
                            <Form
                                onSubmit={this.handleSubmit}
                                render={({handleSubmit, reset, submitting, pristine, values}) => (
                                    <form onSubmit={handleSubmit}>
                                        <Paper style={{padding: 16}}>
                                            <Grid container alignItems="flex-start" spacing={2}>
                                                <Grid item xs={12}>
                                                    <Field
                                                        name="costumeId"
                                                        fullWidth
                                                        required
                                                        component={TextField}
                                                        type="text"
                                                        label="Costume Id"
                                                    />
                                                </Grid>
                                                <Grid item xs={12}>
                                                    <Field
                                                        name="name"
                                                        fullWidth
                                                        required
                                                        component={TextField}
                                                        type="text"
                                                        label="Name"
                                                    />
                                                </Grid>

                                                <Grid item xs={12}>
                                                    <Field
                                                        fullWidth
                                                        name="condition"
                                                        component={Select}
                                                        label="Select a Condition"
                                                        formControlProps={{fullWidth: true}}
                                                    >
                                                        <MenuItem value="NEW">NEW</MenuItem>
                                                        <MenuItem value="LIKE_NEW">LIKE NEW</MenuItem>
                                                        <MenuItem value="USED">USED</MenuItem>
                                                    </Field>
                                                </Grid>

                                                <Grid item style={{marginTop: 16}}>
                                                    <Button
                                                        type="button"
                                                        variant="contained"
                                                        onClick={reset}
                                                        disabled={submitting || pristine}
                                                    >
                                                        Reset
                                                    </Button>
                                                </Grid>
                                                <Grid item style={{marginTop: 16}}>
                                                    <Button
                                                        variant="contained"
                                                        color="primary"
                                                        type="submit"
                                                        disabled={submitting}
                                                    >
                                                        Submit
                                                    </Button>
                                                </Grid>
                                            </Grid>
                                        </Paper>
                                    </form>
                                )}
                            />
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

    console.log(requestOptions);

    return fetch(`${apiEndPoint.apiUrl}/costumes`, requestOptions)
        .then(costume => {
            return costume;
        });
}

export default App;
