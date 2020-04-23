import React from 'react';

import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import FormGroup from '@material-ui/core/FormGroup';
import Grid from '@material-ui/core/Grid';
import Container from '@material-ui/core/Container';
import TextField from '@material-ui/core/TextField';
import {makeStyles} from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
    root: {
        '& .MuiTextField-root': {
            margin: theme.spacing(1),
            width: '30ch',
        },
    },
}));

function App() {
    const classes = useStyles();
    const [costumeRef, condition] = React.useState('');

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
                        <FormGroup row>
                            <form className={classes.root} noValidate autoComplete="off">
                                <div>
                                    <TextField
                                        id="costume-ref"
                                        label="Costume Reference No."
                                        value={costumeRef}
                                        variant="filled"
                                    />
                                    <TextField
                                        id="condition"
                                        label="Condition"
                                        value={condition}
                                        variant="filled"
                                    />
                                </div>
                                <div>
                                    <Button variant="contained" color="primary">
                                        Submit
                                    </Button>
                                </div>
                            </form>
                        </FormGroup>
                    </Grid>
                </Grid>
            </Container>
        </React.Fragment>
    );
}

export default App;
