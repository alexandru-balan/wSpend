<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>wSpend</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
        crossorigin="anonymous">
    <link rel="icon" href="Front_End/res/icons/logo.png">
    <link rel="stylesheet" href="Front_End/styles/master.css">
    <link rel="stylesheet" href="Front_End/styles/index.css">
    <link rel="stylesheet" href="Front_End/styles/configdata.css">
</head>

<body>

    <header>
        <!--This is the navbar on the top of the screen-->
        <nav class="navbar navbar-expand-lg">
            <a class="navbar-brand" href="index.jsp">wSpend</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#content" aria-controls="content">
                <span>
                    <i class="fas fa-bars"></i>
                </span>
            </button>

            <div class="collapse navbar-collapse" id="content">
                <ul class="navbar-nav ml-auto">
                	<li class="nav-item">
                        <a class="nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Front_End/sources/team.jsp">Team</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Front_End/sources/pricing.jsp">Pricing</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <main>
       <div id="container">
           <div id="incomes">
                <form action="adaugIncomes" id="incomesForm" method="post">
                        <input id="email" name="email" type="text" class="form-control" placeholder="Your email">
                        <input id="income" name="name" type="text" class="form-control" placeholder="New Income">
                        <input id="valueIncome" name="amount" type="text" class="form-control" placeholder="Value">
                        <button type="submit" class="btn btn-primary">ADD</button>
                </form>
           </div>
           <div id="expenses">
                <form action="adaugExpenses" id="expensesForm" method="post">
                        <input id="email" name="email" type="text" class="form-control" placeholder="Your email">
                        <input id="expense" name="name" type="text" class="form-control" placeholder="New Expense">
                        <input id="valueExpense" name="amount" type="text" class="form-control" placeholder="Value">
                        <button type="submit" class="btn btn-primary">ADD</button>
                </form>
           </div>
           <div id="savings">
                <form action="adaugSavings" id="savingsForm" method="post">
                        <input id="email" name="email" type="text" class="form-control" placeholder="Your email">
                        <input id="saving" name="name" type="text" class="form-control" placeholder="New Saving">
                        <input id="valueSaving" name="amount" type="text" class="form-control" placeholder="Value">
                        <button type="submit" class="btn btn-primary">ADD</button>
                </form>
           </div>
       </div>
    </main>

    <!--Scripts part-->



    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquerymobile/1.4.5/jquery.mobile.min.js"></script>

    <!--<script>
        (function () {
            ('#logForm').on('submit', function (e) {
                e.preventDefault();
                post('C:\Users\balan\Documents\GitHub\wSpend\post.txt',
                    ('#logForm').serialize(),
                );
            });
        });
    </script>-->

</body>

</html>