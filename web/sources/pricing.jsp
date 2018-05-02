<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>wSpend</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
          crossorigin="anonymous">
    <link rel="icon" href="../res/icons/logo.png">
    <link rel="stylesheet" href="../styles/master.css">
    <link rel="stylesheet" href="../styles/pricing.css">
    <link rel="stylesheet" href="../styles/animate.css">
</head>

<body>
<header>
    <!--This is the navbar on the top of the screen-->
    <nav class="navbar navbar-expand-lg">
        <a class="navbar-brand" href="../index.jsp">wSpend</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#content" aria-controls="content">
        <span>
          <i class="fas fa-bars"></i>
        </span>
        </button>

        <div class="collapse navbar-collapse" id="content">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="team.jsp">Team</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
                <li class="nav-item" id="login-item">
                    <a href="#" class="nav-link" id="login" data-toggle="modal" data-target="#loginModal">LogIn</a>
                </li>
                <li class="nav-item" id="signup-item">
                    <a href="#" class="nav-link" id="signup" data-toggle="modal" data-target="#signupModal">SignUp</a>
                </li>
            </ul>
        </div>
    </nav>

    <!--Modals launched from the login/signup links in the navbar are placed here.-->
    <!--Login modal launched from login link-->
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalTitle">Welcome back!</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="#" id="logForm" method="post">
                    <div class="modal-body">
                        <div class="row mr-auto ml-auto">
                            <input type="email" class="form-control" placeholder="Email" required>
                        </div>
                        <div class="row mr-auto ml-auto">
                            <input type="password" class="form-control" placeholder="Password" required>
                        </div>
                        <p class="text-center">Or
                            <br>Log in with</p>
                        <div class="row socialMedia ml-auto mr-auto">
                            <div class="col">
                                <button class="btn btn-primary fab fa-facebook-square"></button>
                            </div>
                            <div class="col">
                                <button class="btn btn-danger fab fa-google"></button>
                            </div>
                            <div class="col">
                                <button class="btn btn-info fab fa-twitter"></button>
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <a class="mr-auto" href="#signup" data-toggle="modal" data-target="#signupModal" data-dismiss="modal">Sign Up</a>
                        <a id="forgot" href="#">Forgot your password?</a>
                        <button type="submit" class="btn btn-primary">Log In</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!--Signup modal launched from signup screen-->
    <div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="signupModalTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalTitle2">Sign up for free</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="#" id="signForm" method="POST">
                    <div class="modal-body">

                        <div class="row mr-auto ml-auto sign-row">
                            <div class="col">
                                <input type="text" class="form-control" placeholder="First Name" required>
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" placeholder="Last Name" required>
                            </div>
                        </div>
                        <div class="row sign-row2 ml-auto mr-auto">
                            <input type="email" class="form-control" placeholder="Email" required>
                        </div>
                        <div class="row sign-row2 ml-auto mr-auto">
                            <input type="password" class="form-control" placeholder="Password" required>
                        </div>
                    </div>
                    <p class="text-center">Or
                        <br>Sign up with</p>
                    <div class="row mr-auto ml-auto socialMedia">
                        <div class="col">
                            <button class="btn btn-primary fab fa-facebook-square"></button>
                        </div>
                        <div class="col">
                            <button class="btn btn-danger fab fa-google"></button>
                        </div>
                        <div class="col">
                            <button class="btn btn-info fab fa-twitter"></button>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <a href="#login" class="mr-auto" data-toggle="modal" data-target="#loginModal" data-dismiss="modal">Already a member? Log In instead.</a>
                        <button type="submit" class="btn btn-primary">Sign Up</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</header>

<main>
    <section class="tagline">
        <h1 class="title text-center animated fadeInDownBig">Start your journey!</h1>
        <h2 class="subtitle text-center animated fadeInDownBig">Do more awesome things with the power of wSpend</h2>
    </section>

    <div class="row mr-auto ml-auto">
        <div class="col">
            <h3 class="text-center">Starter Plan</h3>
            <div class="col-body">
                <h5 class="text-center">Perfect for the solo adventurer</h5>
                <h6 class="text-center">It contains</h6>
                <ul>
                    <li>One virtual account</li>
                    <li>A limit of 3 virtual wallets</li>
                    <li>Unlimited transactions</li>
                    <li>Unlimited categories</li>
                    <li>Multiple currencies</li>
                    <li>Cloud synching</li>
                </ul>
            </div>
            <div class="col-footer">
                <h6 class="text-center">Price: free</h6>
            </div>
        </div>
        <div class="col">
            <h3 class="text-center">wSpend Family</h3>
            <div class="col-body">
                <h5 class="text-center">Perfect for the united family</h5>
                <h6 class="text-center">It contains</h6>
                <ul>
                    <li>Up to 7 virtual accounts</li>
                    <li>Up to 4 virtual wallets per virtual account</li>
                    <li>Unlimited transactions</li>
                    <li>Unlimited categories</li>
                    <li>Multiple currencies</li>
                    <li>Cloud synching</li>
                    <li>Management panel for parents</li>
                    <li>Detailed reports about children expenses</li>
                    <li>Bank integration for 12 cards(TBA)</li>
                </ul>
            </div>
            <div class="col-footer">
                <h6 class="text-center">Price: $25/month</h6>
            </div>
        </div>
        <div class="col">
            <h3 class="text-center">wSpend Pro</h3>
            <div class="col-body">
                <h5 class="text-center">Perfect for the enthusiast saver</h5>
                <h6 class="text-center">It contains</h6>
                <ul>
                    <li>Three virtual accounts</li>
                    <li>A limit of 7 virtual wallets</li>
                    <li>Unlimited transactions</li>
                    <li>Unlimited categories</li>
                    <li>Multiple currencies</li>
                    <li>Cloud synching</li>
                    <li>Access to beta features</li>
                    <li>Bank integration for 3 cards(TBA)</li>
                </ul>
            </div>
            <div class="col-footer">
                <h6 class="text-center">Price: $12/month</h6>
            </div>
        </div>
        <div class="col">
            <h3 class="text-center">wSpend Enterprise</h3>
            <div class="col-body">
                <h5 class="text-center">The best to get your finances in order</h5>
                <h5 class="text-center">Contact us for a license</h5>
            </div>
            <div class="col-footer">
                <h6 class="text-center">Price: $10/user/month</h6>
            </div>
        </div>
    </div>
</main>


<!--Bootstrap js-->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>

</html>