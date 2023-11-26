const vending_machine = require('./part/admin.js');

const new_vending_machine = new vending_machine();
while(1) {
    new_vending_machine.start();
}