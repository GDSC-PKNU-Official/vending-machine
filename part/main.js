const reader = require('readline-sync');
const fs = require('fs');

class vending_machine_main {
    refresh() {
        const data = JSON.parse(fs.readFileSync('./data.json', 'utf8'));
        
        this.select = data[0];
        this.how = data[1];
        this.count = data[2];
        this.all = data[3];

        this.auth = '사용자';
    }

    read_data(select_arr, arr, do_type = 0) {
        let input;
        while(1) {
            process.stdout.write(this.auth + " 입력 > ");
            input = reader.question();
            if(Object.keys(select_arr).includes(input) || (do_type === 1 && input === 'admin')) {
                break;
            } else {
                console.log("잘못된 입력");
            }
        }
        
        if(input !== 'admin') {
            input = Object.keys(arr)[Number(input) - 1];
        }
        
        return input;
    }

    output_for_data(select, data_type = 0) {
        const select_length = Object.keys(select).length;
        let select_arr = {};
        for(let for_a = 0; for_a < select_length; for_a++) {
            if(data_type === 2 && select[Object.keys(select)[for_a]] === '') {
                console.log("[0] " + Object.keys(select)[for_a]);
                select_arr[0] = Object.keys(select)[for_a];
            } else {
                process.stdout.write("[" + String(for_a + 1) + "] " + Object.keys(select)[for_a]);
                if(data_type === 1 && select[Object.keys(select)[for_a]][1] !== '') {
                    console.log(" (" + select[Object.keys(select)[for_a]][1] + ")");
                } else {
                    console.log("");
                }
                
                select_arr[for_a + 1] = Object.keys(select)[for_a];
            }
        }

        return select_arr;
    }

    start() {
        this.refresh();
        console.log("[어서와요! GDSC 음료 자판기]");

        this.user_ice_or_hot();
    }
}
module.exports = vending_machine_main;