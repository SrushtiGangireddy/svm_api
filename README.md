# svm_api

Soda vending machine api calls

https://sodamachine-api.herokuapp.com/ => Hits the home function and gets the response with attributes: Balance, soda selected, change, list of sodas, machine state (string)

https://sodamachine-api.herokuapp.com/insertAmount/{amount}/{quantity} => 
Get function that takes in denomination and quantity and returns the state of machine.

https://sodamachine-api.herokuapp.com/dispenseSoda/{id} => 
Get function that takes soda is and dispenses the soda if balance is enough.

https://sodamachine-api.herokuapp.com/returnChange => 
Returns the change if present

https://sodamachine-api.herokuapp.com/getAvailabilty => 
Gets the soda list with quantity of each soda available.
