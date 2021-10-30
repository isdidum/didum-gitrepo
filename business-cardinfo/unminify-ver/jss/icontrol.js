/**
 * @author A., Didum
 * @class ControlMgr()
 * @description ControlMgr(): specific function constructor - contains component reactions to user
 * @param {Number} length - length of array index
 */
function ControlMgr(length){
    
    //instance variable are better declared private to preserve the integrity of object.
    this.isConfirmed = ControlMgr.getConfirm(false);
    this.currentIndex = -1;
    this.currentCount = 0;
    this.cntr = 0;
    this.INDEX_LENGTH = length;
    this.multipleRec = [];
    this.clientRecord = new Array(this.INDEX_LENGTH);
    
    // initializes clientRecord array to null-value
    for(var i=0; i<this.clientRecord.length; i++){
        this.clientRecord[i] = null;
    }
    
    // string object literal to display friendly messages
    this.msgs = {
        full : "SORRY: client array is full.",
        empty: "SORRY: client array is either empty or\nthe current index is at -1 or both.",
        notfound : "QUERY AGENT - SORRY: no record found.",
        recfound : "QUERY AGENT - YES, record found.",
        ebin : "SORRY: Recycle bin is empty.\nThere is no record in the bin.",
        on   : "Turn on query field.",
        off  : "Turn off query field.",
        nmquery : "Query by the following: \n1. Complete name or\n2. First name or\n3. Last name or\n4. Middle name",
        invalid : "SORRY: you did not enter a query value.\nPlease provide a query value.",
        activate: "SORRY: please activate query field\nby clicking the checkbox.",
        multiple: "QUERY AGENT: multiple records found\nwith this lookup name\nplease modify lookup value."
    };  
    
    // user-data to be preloaded if chosen by current user
    this.usr = {
        info : [
            {id: 1,  name : "Alex Y",    title : "DB Analyst",     phone : "919-233-3658", email : "alex@gmail.com",    org : "Shell Gas",   addy : "1213 Northern Ave", city : "Austin",     st : "tx", zip : 52315, rep : "Sale rep-1", 
                url:"https://www.home.alex.com"},
            {id: 2,  name : "Didum K",   title : "Assist. Sec.",   phone : "515-441-1667", email : "dee@hotmail.com",  org : "ESRI",        addy : "100 Madison Penn",  city : "Madison",    st : "pa", zip : 63254, rep : "No rep client", 
                url:"http://www.james.net"},
            {id: 3,  name : "James G",   title : "Accountant",     phone : "613-325-5225", email : "james@hotmail.com", org : "Chevron Gas", addy : "South 4th Ave",     city : "St. Paul",   st : "mn", zip : 45585, rep : "Best Mpia", 
                url:"https://www.chevrongas.net"},
            {id: 4,  name : "Didum D",   title : "Sr. JS Dev",     phone : "563-235-5356", email : "didum@gmail.com",   org : "IA-DOT",      addy : "800 Lincoln Way",   city : "Ames",       st : "ia", zip : 50010, rep : "E. Ambrose", 
                url:"ftp://disys.com"},
            {id: 5,  name : "Miracle O", title : "Student intern", phone : "847-352-9865", email : "obeta@yahoo.com",   org : "Z-Tv",        addy : "1418 Ter Palace",   city : "Fairfax",    st : "va", zip : 22031, rep : "L. Eunice", 
                url:"null"},
            {id: 6,  name : "Best Mpia", title : "Manufacturing Mgr",  phone : "667-652-6896", email : "mpia@protonmail.com", org : "Microsoft",  addy : "Westwood 5th Ave",  city : "Bethlehem",  st : "nj", zip : 52051, rep : "K. Rachel", 
                url:"http://www.microsoft.com"}
        ],
        deftip : [ //data-field tool-tips
            "User's full-name", "User's job title", "User's phone", "User's email", "Company's name", "Company's address", "Company's city", "Company's state", "Company's zip-code", "Client's representative", "Company's url"
        ],
        ttip : [ //data-field tool-tips
            "Name: ", "Title: ", "Phone: ", "Email: ", "Company: ", "Address: ", "City: ", "State: ", "Zip: ", "Representative: ", "Url: "
        ],
        type : "client-info"
    };
    
    // initially display the current record method
    this.showCurrentRec();
};

/**
 * enableField(): unlocks the edit content of each field
 * @returns {void}
 */
ControlMgr.prototype.enableField = function(){
    var dataId = this.getComponentById();
    for(var i=0; i<dataId.length; i++){ 
        dataId[i].disabled = false;
        dataId[i].style.backgroundColor = 'rgb(256,256,256)';
    }
};

/**
 * disableField(): locks the edit content of each field
 * @returns {void}
 */
ControlMgr.prototype.disableField = function(){
    var dataId = this.getComponentById();
    for(var i=0; i<dataId.length; i++){ //make non-editable other fields
        dataId[i].disabled = true;
        dataId[i].style.backgroundColor = 'rgb(200,200,230)';
        //dataId[i].setAttribute('style', 'background-color:rgb(200,200,230)');//#eeeedd
    }
};

/**
 * @description first(): button to display first record
 * @returns {first()}
 */
ControlMgr.prototype.first = function(){ //works
    try{
        if(this.currentCount == 0){
            this.currentIndex = -1;
        } else {
            this.currentIndex = 0;
        }
        this.showCurrentRec();
        this.showTooltip();
    }catch(err){
        alert('File: *./icontrol.js\nMethod: first()\nMessage: '+err.message);
    }
};

/**
 * @description previous(): button to display previous record
 * @returns {previous()}
 */
ControlMgr.prototype.previous = function(){ 
    try{
        if(this.currentCount == 0){
            this.currentIndex = -1;
        } else if(this.currentIndex != -1){
            this.currentIndex = Math.min(this.currentIndex-1, this.currentCount-1);
        }
        this.showCurrentRec();
        this.showTooltip();
    }catch(err){
        alert('File: *./icontrol.js\nMethod: previous()\nMessage: '+err.message);
    }
};

/**
 * @description next(): button to display next record
 * @returns {next()}
 */
ControlMgr.prototype.next = function(){ 
    try{
        if(this.currentCount == 0){
            this.currentIndex = -1;
        } else {
            this.currentIndex = Math.min(this.currentCount-1, this.currentIndex+1);
        }
        this.showCurrentRec();
        this.showTooltip();
    }catch(err){
        alert('File: *./icontrol.js\nMethod: next()\nMessage: '+err.message);
    }
};

/**
 * @description last(): button to display last record
 * @returns {last()}
 */
ControlMgr.prototype.last = function(){ //works
    try{
        if(this.currentCount == 0){
            this.currentIndex = -1;
        } else {
            this.currentIndex = Math.max(this.currentCount-1, this.currentIndex-1);
        }
        this.showCurrentRec();
        this.showTooltip();
    }catch(err){
        alert('File: *./icontrol.js\nMethod: last()\nMessage: '+err.message);
    }
};

/**
 * @description clear(): button to clear current record
 * @returns {clear()}
 */
ControlMgr.prototype.clear = function(){ //works
    try{
        var dataId = this.getComponentById();
        for(var i=0; i<dataId.length; i++){
           dataId[i].value = '';
        }
    }catch(err){
        alert('File: *./icontrol.js\nMethod: clear()\nMessage: '+err.message);
    }
};

/**
 * @description bin(): facilitator - button to display deleted contents in textarea element
 * @param {Boolean} bool
 * @returns {bin()}
 */
ControlMgr.prototype.bin = function(bool){
    try{
        var bin = document.getElementById('bin');
        var cssTxt = "text-decoration:none; display:block; visibility:visible; text-align:left; position:relative;";
        if(bool){
            if((bin.value == '') || (bin.value.length == 0)) {
                bin.style.display = 'none';
                ControlMgr.msgBox(this.msgs.ebin);
            } else {
                bin.style.cssText = cssTxt;
            }
        } else {
            bin.style.display = 'none';
            //bin.style.visibility = 'hidden'; //keeps component layout in view, but hides physical object
        }
    } catch(err) {
        alert('File: *./icontrol.js\nMethod: bin()\nMessage: '+err.message);
    }
};

/**
 * @description cleanBin(): 1 to show tray (recycle bin textarea), 0 otherwise to hide and empty it
 * @param {Number} num : numeric value (1 or 0)
 * @returns {void}
 */
ControlMgr.prototype.cleanBin = function(num){
    var bin = document.getElementById('bin');
        var cssTxt = "text-decoration:none; display:block; visibility:visible; text-align:left; position:relative;";
        if(num == 1){
            bin.style.cssText = cssTxt;
        } else if(num == 0) {
            bin.value = "";
            bin.style.display = 'none';
        }
};

/**
 * @description enable(): facilitator - enables search input field
 * @returns {void}
 */
ControlMgr.prototype.enable = function(){ //works
    try{
        var toggle = document.getElementById('cbox');
        var find = document.getElementById('find');
        var dataId = this.getComponentById();
        
        //when checkbox is checked
        if (toggle.checked){
            if(find.disabled){
                toggle.title = this.msgs.off;
                find.disabled = false;
                find.setAttribute('style', 'background-color:white;'); //'rgb(239,239,239)'
                
                /** @returns {void} applies css style */
                find.onmouseover = function(){
                    find.style.cssText = 'border: 2px solid blue; background-color: yellow';
                };
                
                /** @returns {void} applies css style */
                find.onmouseout = function(){
                    find.style.cssText = 'border: 2px solid black; background-color: white';
                };
                find.value = ''; 
                for(var i=0; i<dataId.length; i++){ 
                    dataId[i].disabled = true;  
                    dataId[i].setAttribute('style', 'background-color:#eeddee');
                }
            }
        }
        
        //when checkbox is unchecked
        if(!toggle.checked){
            if(!find.disabled){
                toggle.title = this.msgs.on;
                find.disabled = true;
                find.setAttribute('style', 'background-color: #eeddee; border: 2px solid black;');
                find.value = ''; 
                for(var i=0; i<dataId.length; i++){ 
                    dataId[i].disabled = false;     
                    
                }
                this.disableField();
            }
        } 
    }catch(err){
        alert('File: *./icontrol.js\nMethod: eSearch()\nMessage: '+err.message);
    }
};

/**
 * @description add(): accessor - stores each record
 * @returns {add()}
 */
ControlMgr.prototype.add = function(){ //works
    try{
        if(this.currentCount == this.clientRecord.length){
            ControlMgr.msgBox(this.msgs.full);
            this.clear();
            this.first();
            return;
        }
        var screenData, validation, isValue = this.isConfirmed;
        if(isValue){ //add preloaded user data
            screenData = this.loadData()[this.currentCount][0];
            validation = this.loadData()[this.currentCount][1];
        } else {    //user manually enters raw data
            screenData = this.getDataOnScreen()[0];
            validation = this.getDataOnScreen()[1];
        }
        
        if(validation != null){ //if the data is invalid, exit this method without adding record
            ControlMgr.msgBox('Method: add()\n'+validation); //hence, air the validation error message
            return;
        }
        
        this.clientRecord[this.currentCount] = screenData;
        this.currentIndex = this.currentCount;
        this.currentCount++;
        
        this.showCurrentRec();
        this.showTooltip();
    }catch(err){
        alert('File: *./icontrol.js\nMethod: add()\nMessage: '+err.message);
    }
};

/**
 * @description modify(): button to modify or to update current record
 * @returns {modify()}
 */
ControlMgr.prototype.modify = function(){
    try{
        var validation = this.getDataOnScreen()[1];
        if(validation != null){ //if the data is invalid, exit this method without updating record
            ControlMgr.msgBox('Method: modify()\n'+validation); //hence, air the validation error message
            return;
        }
        
        if(this.currentIndex != -1){
            //first get the input from the text-fields
            var screenData = this.getDataOnScreen()[0];
            this.clientRecord[this.currentIndex] = screenData;
            
            this.showCurrentRec();
        }
    } catch (err){
        alert('File: *./icontrol.js\nMethod: modify()\nMessage: '+err.message);
    }
};

/**
 * @description remove(): button to delete current record
 * @returns {remove()}
 */
ControlMgr.prototype.remove = function(){
    try{
        var bin = document.getElementById('bin');
        var validation = this.getDataOnScreen()[1];
        var isDeleted = ControlMgr.getConfirm(true);
        
        if(validation != null){
            ControlMgr.msgBox('Method: remove()\n'+validation);
            return;
        }
        
        if (this.currentIndex != -1){
            if(isDeleted){
                var rec = this.clientRecord.splice(this.currentIndex, 1); 
                this.currentCount--;
                this.currentIndex--; //fixes problem with rec is undefined error msg
                
                if(bin) { //string concatenation to recyle bin
                    bin.value += 'Counter: '+(this.cntr++)+'\n'+rec +'\n\n';
                }
                if (this.clientRecord.length == 0){
                    this.clientRecord = new Array(this.INDEX_LENGTH);
                    this.currentIndex = -1;
                    this.currentCount = 0;
                    this.cntr = 0;
                    bin.value = '';    //empties recycle bin
                }
            }
        }
        this.first();
    }catch(err){
        alert('File: *./icontrol.js\nMethod: remove()\nMessage: '+err.message);
    }
};

/**
 * @description query(): searches clientRecord array to return matched record
 * @returns {query()}
 */
ControlMgr.prototype.query = function(){
    try{
        var toggle = document.getElementById('cbox');
        if (toggle.checked){
            var data = [], dataId = [], counter;
            var find = document.getElementById('find'), qValue = '';
            var curIndex = document.getElementById('indexc');
            
            data = this.clientRecord;
            if(data[this.currentIndex] == null){    
                ControlMgr.msgBox(this.msgs.empty); 
                return;                             
            }
            if(find) qValue = find.value.toUpperCase();
            if((qValue.length != 0) || (qValue != '')){
                counter = this.lookUp(qValue)[0];
                var curPosition = this.lookUp(qValue)[1];
                                
                if(counter > 1){
                    ControlMgr.msgBox(this.msgs.multiple+'\n\n'+this.multipleRec);
                    this.first();
                    return;
                }
                
                if(counter === 1){
                    ControlMgr.msgBox(this.msgs.recfound);
                    var rec = this.clientRecord[curPosition];
                    
                    var currentRec = [
                        rec.name, rec.title, rec.phone, rec.email, rec.company,
                        rec.address, rec.city, rec.state, rec.zip, rec.rep, rec.url
                    ];
                    dataId = this.getComponentById();
                    for(var k=0; k<dataId.length; k++){
                        dataId[k].value = currentRec[k];
                        dataId[k].title = (this.usr.ttip[k] + dataId[k].value);
                    }
                    if(curIndex){ 
                        curIndex.value = curPosition;
                        //fixes problem with wrong record being deleted upon search
                        this.currentIndex = curIndex.value; //updates currentIndex
                    }
                    return;
                }
                    
                if(counter === 0){
                    ControlMgr.msgBox(this.msgs.notfound); //notfound = empty record
                    this.clear();
                    this.first();
                    return;
                }
            } else if ((qValue.length == 0) || (qValue == '')){
                ControlMgr.msgBox(this.msgs.invalid);
                return;
            }
        }
        if(!toggle.checked){
            ControlMgr.msgBox(this.msgs.activate);
            return;
        }
    }catch(err){
        alert('File: *./icontrol.js\nMethod: query()\nMessage: '+err.message);
    }
};

/**
 * @description lookUp(): Query facilitator
 * @param {String} query
 * @returns {Array}
 */
ControlMgr.prototype.lookUp = function(query){
    try{
        var data = this.clientRecord, counter = 0, pos;
        var multiple = [];
        
        //search algorithm: full-name including middle initial
        for(var i=0; i<data.length; i++){
            if(data[i] != null){
                if(data[i].name === query){
                    pos = i;
                    counter += 1;
                    multiple[i] = data[i];
                }
            }
        }
        
        //search algorithm: uses mi, firstname, or lastname
        if(counter == 0){   //full-name search failed
            for(var i=0; i<data.length; i++){
                if(data[i] != null){
                    var condition = (this.findByFirst(data[i].name) === query) 
                            || (this.findByLast(data[i].name) === query) || (this.findByMi(data[i].name) === query);
                    if(condition){
                        pos = i;
                        counter += 1;
                        multiple[i] = data[i];
                    }
                }
            }
        }
        if (counter > 1) this.multipleRec = multiple.valueOf();
        return [counter, pos];
    }catch(err){
        alert('File: *./icontrol.js\nMethod: lookUp()\nMessage: '+err.message);
    }
};

/**
 * @description getDataOnScreen(): accessor - returns current record and validation
 * @returns {Array}
 */
ControlMgr.prototype.getDataOnScreen = function(){ //works
    try {
        var name = this.getComponentById()[0].value.toUpperCase();
        var title = this.getComponentById()[1].value.toUpperCase();
        //var phone = ControlMgr.pformat(this.getComponentById()[2].value);
        var phone = this.getComponentById()[2].value;
        var email = this.getComponentById()[3].value.toUpperCase();
        var org = this.getComponentById()[4].value.toUpperCase();
        var address = this.getComponentById()[5].value.toUpperCase();
        var city = this.getComponentById()[6].value.toUpperCase();
        var state = this.getComponentById()[7].value.toUpperCase();
        var zip = this.getComponentById()[8].value;
        var rep = this.getComponentById()[9].value.toUpperCase();
        var url = this.getComponentById()[10].value;

        var model = new BusinessModel(name, title, phone, email, org, address, city, state, zip, rep, url);
        return [model, model.validateInfo()];
    } catch (err) {
        alert('File: *./icontrol.js\nMethod: getDataOnScreen()\nMessage: '+err.message);
    }
};

/**
 * @description loadData(): facilitator - loads user information into data-fields in view
 * @returns {Array}
 */
ControlMgr.prototype.loadData = function(){
    try{
        var nm = [], ti = [], ph = [], em = [], or = [], ad = [], ur = [];
        var ct = [], st = [], rp = [], zp = [], model = [], obj = [];
        
        for(var i=0; i<this.usr.info.length; i++){
            nm[i] = this.usr.info[i].name.toUpperCase();
            ti[i] = this.usr.info[i].title.toUpperCase();
            //ph[i] = ControlMgr.pformat(this.usr.info[i].phone);
            ph[i] = this.usr.info[i].phone;
            em[i] = this.usr.info[i].email.toUpperCase();
            or[i] = this.usr.info[i].org.toUpperCase();
            ad[i] = this.usr.info[i].addy.toUpperCase();
            ct[i] = this.usr.info[i].city.toUpperCase();
            st[i] = this.usr.info[i].st.toUpperCase();
            zp[i] = this.usr.info[i].zip;
            rp[i] = this.usr.info[i].rep.toUpperCase();
            ur[i] = this.usr.info[i].url;
            
            model[i] = new BusinessModel(nm[i], ti[i], ph[i], em[i], or[i], ad[i], ct[i], st[i], zp[i], rp[i], ur[i]);
            obj[i] = [model[i], model[i].validateInfo()];
        }
        return obj;
    }catch(err){
        alert('File: *./icontrol.js\nMethod: loadData()\nMessage: '+err.message);
    }
};

/**
 * @description getComponentById(): returns each id associated with each component in view-interface
 * @returns {Array}
 */
ControlMgr.prototype.getComponentById = function(){
    try{ //accesses the id of each component
        var name, title, phone, email, org, address, city, state, zip, rep, url;
        name = document.getElementById('name');
        title = document.getElementById('jtitle');
        phone = document.getElementById('phone');
        email = document.getElementById('email');
        org = document.getElementById('org');
        address = document.getElementById('addy');
        city = document.getElementById('city');
        state = document.getElementById('state');
        zip = document.getElementById('zip');
        rep = document.getElementById('rep');
        url = document.getElementById('url');
        return [name, title, phone, email, org, address, city, state, zip, rep, url];
    }catch(err){
        alert('File: *./icontrol.js\nMethod: getComponentById()\nMessage: '+err.message);
    }
};

/**
 * @description showCurrentRec(): facilitator - displays current record
 * @returns {showCurrentRec()}
 */
ControlMgr.prototype.showCurrentRec = function(){
    try{
        var curIndex = document.getElementById('indexc');
        var curCount = document.getElementById('countc');
        var dataId = this.getComponentById();   //array
        
        if(this.currentIndex == -1){
            this.clear();
        } else {
           var obj = this.clientRecord[this.currentIndex];
           if (obj == null) return;
           //rec = this.clientRecord[this.currentIndex]; //var rec = JSON.stringify(rec);
           
           var currentRec = [obj.name, obj.title, obj.phone, obj.email, obj.company, obj.address,
           obj.city, obj.state, obj.zip, obj.rep, obj.url];
           for(var i=0; i<dataId.length; i++){
               dataId[i].value = currentRec[i];
           }
       }
       if(curCount) curCount.value = this.currentCount + ' / ' + this.clientRecord.length;
       if(curIndex) curIndex.value = this.currentIndex;
    }catch(err){
        alert('File: *./icontrol.js\nMethod: showCurrentRec()\nMessage: '+err.message);
    }
};

/**
 * @description enter(): facilitator - receives and processs keyboard enter key
 * @param {Event} evt
 */
ControlMgr.prototype.enter = function(evt){
    if (evt.keyCode == 13 || evt.which == 13){
        this.query();
        return false;
    }
    return true;
};

/**
 * @description msgBox(): facilitor - airs error messages (this is class method)
 * @param {String} msg
 * @returns {meg()}
 */
ControlMgr.msgBox = function(msg){
    window.alert(msg);
};

/**
 * @description initControl(): facilitator - true to load data, false otherwise to enter raw data
 * @param {Boolean} isBool true for delete button, false otherwise for data preload
 * @returns {Boolean}
 */
ControlMgr.getConfirm = function(isBool){    
    var confirmValue;
    if(isBool){
        confirmValue = confirm('Delete button is pressed\nAre you sure?');
        if(confirmValue) return true;   //deletes current user record
        else return false;              //bypasses deletion of user record
    } else {
        confirmValue = confirm('Do you want to preload user data?');
        if(confirmValue) return true;   //allows you to preload user data
        else return false;              //forces you to manually load user data
    }
};

/**
 * @description pformat(): facilitator - formats phone number
 * @param {String} param
 * @returns {String}
 */
ControlMgr.pformat = function(param){
    try{
        var str0, str1, str2, str3, str4, string;
        str0 = param.substring(0, 3);
        str2 = param.substring(3, 4);
        str3 = param.substring(6);
        str1 = param.replace(str0, '(' + str0 + ')');
        str4 = str1.replace(str2, (' ' + str2));
        string = str4.replace(str3, ('-' + str3));
        return string;
    }catch(err){
        alert('File: *./icontrol.js\nMethod: pformat()\nMessage: '+err.message);
    }
};

/**
 * @description nmParser(): parses and returns user name
 * @param {String} name - the name provided by the user
 * @returns {Array}
 */
ControlMgr.prototype.nmParser = function(name){
    //this algorithm works for people with only one middle-name and no title prefixes
    try{
        /**
         * accepted formats: no titles/prefixes permitted within name text
         * 1. last, first middle    //ok
         * 2. last, first           //ok
         */
        var fname = null, lname = null, mi = null; //return these in an array
        var lastName = null, firstName = null, middleName = null;
        var pos1 = name.indexOf(', ',0);
        
        if(pos1 != -1){
            lastName = name.substring(0, pos1);
            if(lastName != null || lastName != '') lname = lastName;
            var pos2 = name.indexOf(' ', pos1+2); //comma and space = +2
            if(pos2 != -1){
                firstName = name.substring(pos1+2, pos2);
                if(firstName != null || firstName != '') fname = firstName;
                var pos3 = name.indexOf(' ', pos2);
                if(pos3 != -1){
                    middleName = name.substring(pos3+1, name.length);
                    if(middleName != null || middleName != '') mi = middleName;
                }
            } else if(pos2 == -1){
                firstName = name.substring(pos1+2, name.length);
                if(firstName != null || firstName != '') fname = firstName;
            }
        }
        
        /**
         * accepted format: no titles/prefixes permitted within name text
         * 3. first middle last //ok
         * 4. first last        //ok
         * 5. first             //ok
         */
        var posA = name.indexOf(' ', 0);
        if((posA != -1) && (name.substring(posA-1, posA) != ',')){
            firstName = name.substring(0, posA);
            if(firstName != null || firstName != '') fname = firstName;
            var posB = name.indexOf(' ', posA+1); //space = +1
            if(posB != -1){
                middleName = name.substring(posA+1, posB);
                if(middleName != null || middleName != '') mi = middleName;
                var posC = name.indexOf(' ', posB);
                if(posC != -1){
                    lastName = name.substring(posB+1, name.length);
                    if(lastName != null || lastName != '') lname = lastName;
                }
            } else if(posB == -1) {
                lastName = name.substring(posA+1, name.length);
                if(lastName != null || lastName != '') lname = lastName;
            }
            
        } else if(posA == -1){
            firstName = name.substring(0, name.lenght);
            if(firstName != null || firstName != '') fname = firstName;
        }
        return [fname, lname, mi];
    }catch(err){
        alert('File: *./icontrol.js\nMethod: nmParser()\nMessage: '+err.message);
    }
};

/**
 * @description findByFirst(): this method allows the user to specific name search in query field
 * @param {String} usrname - name of the user
 * @returns {String}
 */
ControlMgr.prototype.findByFirst = function(usrname){
    var fname, sname, mi;
    var name = "";

    if (usrname.length != 0) {
        var user = this.nmParser(usrname); //returns an array
        fname = user[0]; sname = user[1]; mi = user[2];
        
        if ((fname != null) && (sname != null) && (mi != null)) {
            name = fname; //+ " " + mi + " " + sname;
        }
        if ((fname != null) && (sname != null) && (mi == null)) {
            name = fname; //+ " " + sname;
        }
        if ((fname != null) && (sname == null) && (mi == null)) {
            name = fname;
        }
    }
    return name;
};

/**
 * @description findByLast(): this method allows the user to specify name search in query field
 * @param {String} usrname - name of the user
 * @returns {String}
 */
ControlMgr.prototype.findByLast = function(usrname){
    var fname, sname, mi, name = "";

    if (usrname.length != 0) {
        var user = this.nmParser(usrname); //returns an array
        fname = user[0]; sname = user[1]; mi = user[2];
        
        if ((fname != null) && (sname != null) && (mi != null)) {
            name = sname;
        }
        if ((fname != null) && (sname != null) && (mi == null)) {
            name = sname;
        }
    }
    return name;
};

/**
 * @description findByMi(): this method allows the user to specific name search in query field
 * @param {String} usrname - name of the user
 * @returns {String}
 */
ControlMgr.prototype.findByMi = function(usrname){
    var name = "";

    if (usrname.length != 0) {
        var user = this.nmParser(usrname); //returns an array
        if ((user[0] != null) && (user[1] != null) && (user[2] != null)) {
            name = user[2];
        }
    }
    return name;
};

/**
 * @description showTooltip(): displays tool in accordance with each data-field
 * @returns {void} description
 */
ControlMgr.prototype.showTooltip = function(){    
    var id = this.getComponentById();
    if(this.currentIndex == -1) {
        for(var i=0; i<id.length; i++){
            id[i].title = this.usr.deftip[i];
        }
    } else {
        var rec = this.clientRecord[this.currentIndex]; //rec=an object
        if (rec == null) return;
        var clientData = [
            rec.name, rec.title, rec.phone, rec.email, rec.company,
            rec.address, rec.city, rec.state, rec.zip, rec.rep, rec.url
        ];
        
        for (var i = 0; i < id.length; i++) {
            if (clientData[i] != "") id[i].title = (this.usr.ttip[i] + clientData[i]);
        }
    }
};
