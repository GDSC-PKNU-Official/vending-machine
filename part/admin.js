const reader = require('readline-sync');
const fs = require('fs');

const vending_machine_user = require('./user.js');

class vending_machine extends vending_machine_user {
    admin_main() {
        console.log('[관리자 페이지]');
        this.auth = "admin";

        const select = {
            "총 수익 확인" : "",
            "음료 관리" : ""
        }
        const select_arr = this.output_for_data(select);

        this.admin_select_0 = this.read_data(select_arr, select);
        console.log('[' + this.admin_select_0 + ']');

        if(this.admin_select_0 === Object.keys(select)[0]) {
            this.admin_total_profit();
        } else {
            this.admin_drink_manager();
        }
    }

    admin_total_profit() {
        console.log('[관리자 페이지 - 총 수익]');
        console.log(String(this.all) + '원');
    }

    admin_drink_manager() {
        console.log('[관리자 페이지 - 음료 관리]');

        let select = {
            "음료 확인" : "",
            "음료 추가" : "",
            "음료 삭제" : ""
        }
        const select_arr = this.output_for_data(select);

        this.admin_select_1 = this.read_data(select_arr, select);
        console.log('[' + this.admin_select_1 + ']');

        if(this.admin_select_1 === Object.keys(select)[0]) {
            this.admin_drink_list();
        } else if(this.admin_select_1 === Object.keys(select)[1]) {
            this.admin_add_drink();
        } else {
            this.admin_remove_drink();
        }
    }

    admin_drink_list() {
        const select_length = Object.keys(this.select).length;
        for(let for_a = 0; for_a < select_length; for_a++) {
            console.log('[' + Object.keys(this.select)[for_a] + ']');
            this.output_for_data(this.select[Object.keys(this.select)[for_a]]);
        }
    }

    admin_add_drink() {
        console.log("음료를 선택 해주세요!");

        const select_arr = this.output_for_data(this.select);
    
        this.admin_page_3_select = this.read_data(select_arr, this.select);
        console.log('[' + this.admin_page_3_select + ']');
        
        console.log('음료 이름을 설정하세요');
        
        process.stdout.write("admin 입력 > ");
        let input = reader.question();
        const name = input;

        console.log('음료 가격을 설정하세요');
        let money = 0;
        while(1) {
            process.stdout.write("admin 입력 > ");
            input = reader.question();
            
            if(input.match(/^[0-9]+$/)) {    
                money = Number(input);
                break;
            }
        }

        let data = JSON.parse(fs.readFileSync('./data.json', 'utf8'));
        data[0][this.admin_page_3_select][name] = money;
        fs.writeFileSync('data.json', JSON.stringify(data));

        console.log('[관리자 페이지 - 추가완료]');
        console.log(name + ' : ' + money);
    }

    admin_remove_drink() {
        console.log("음료를 선택 해주세요!");

        const select_arr = this.output_for_data(this.select);
    
        this.admin_page_3_select = this.read_data(select_arr, this.select);
        console.log('[' + this.admin_page_3_select + ']');

        const select_arr_2 = this.output_for_data(this.select[this.admin_page_3_select]);

        this.admin_page_3_select_2 = this.read_data(select_arr_2, this.select[this.admin_page_3_select]);
        console.log('[' + this.admin_page_3_select_2 + ']');

        let data = JSON.parse(fs.readFileSync('./data.json', 'utf8'));

        console.log('[관리자 페이지 - 음료 삭제 완료]');
        console.log(this.admin_page_3_select_2 + ' : ' + data[0][this.admin_page_3_select][this.admin_page_3_select_2]);

        delete data[0][this.admin_page_3_select][this.admin_page_3_select_2];
        fs.writeFileSync('data.json', JSON.stringify(data));
    }
}
module.exports = vending_machine;