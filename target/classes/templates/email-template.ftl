<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  </head>
  <body class="container">
    <nav class="navbar navbar-dark bg-primary">
   <a class="navbar-brand" href="#">Your Booking Confirmation with Airline System</a>
</nav>
<div class="row mt-4">
  <div class="col-6">
  <h5>
Hello ${name},Below are your travel Detail
</h5>
  </div>
</div>
<div class="row mt-4">
  <div class="col">
    <div class="card border-success">
  <div class="card-header bg-success">
    Flight Detail
  </div>
  <div class="card-body">
    
   <div class="table-responsive">
  <table class="table border-0">
    <tbody>
    <tr>
      <th>Operator</th>
      <td><img src="${operatorLogo}" width="30" height="30"> ${operatorName}</td>
      <th>Flight Number</th>
      <td>${flightNumber}</td>
    </tr>
    <tr>
      <th>Date of Journey</th>
      <td>${dateOfJourney}</td>
      <th>Duration</th>
      <td>${duration}</td>
    </tr>
    <tr>
      <th>Source</th>
      <td>${source}</td>
      <th>Destination</th>
      <td>${destination}</td>
    </tr>
  </table>
</div>
    
  </div>
</div>
  </div>

</div>
<div class="row mt-4">
  <div class="col">
   <div class="card border-success">
  <div class="card-header bg-success">
    Payment Detail
  </div>
  <div class="card-body">
    
   <div class="table-responsive">
  <table class="table border-0">
    <tbody>
      <tr>
      <th>Number of Seats</th>
      <td>${numberOfSeats}</td>
      <th>Seat Numbers</th>
      <td>${seatNumbers}</td>
    </tr>
    <tr>
      <th>Price Per Seat</th>
      <td>${pricePerSeat} USD</td>
      <th>Total Price</th>
      <td>${totalPrice} USD</td>
    </tr>
    <tr>
      <th>Mode of Payment</th>
      <td>${modeOfPayment}</td>
      <th>Booking Status</th>
      <td>${bookingStatus}</td>
    </tr>
  </table>
</div>
    
  </div>
</div>
  </div>

</div>

<div class="row mt-4">
  <div class="col">
   <div class="card border-success">
  <div class="card-header bg-success">
    Booking Detail
  </div>
  <div class="card-body">
    
   <div class="table-responsive">
  <table class="table border-0">
    <tbody>
    <tr>
      <th>Name</th>
      <td>${name}</td>
    </tr>
    <tr>
      <th>Email</th>
      <td>${email}</td>
    </tr>
  </table>
</div>
    
  </div>
</div>
  </div>

</div>

<div class="row mt-4">
  <div class="col">
     <div class="card border-warning">
  <div class="card-header bg-warning">
   <center> <h6>HAPPY JOURNEY!</h6></center>
  </div>
 
</div>
  </div>

</div>
<hr>
<div class="row justify-content-center">
  <div class="col">
      <center><p style="font-size: 12px;">Airline Systems &copy; | All Rights Reserved.</p></center>
  </div>
</div>

  </body>
</html>