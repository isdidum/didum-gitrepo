/**
 * @description BusinessModel(): specific function constructor - contains business logic (data fields)
 * @param {String} name - complete full name of client
 * @param {String} title - position title of client
 * @param {String} phone - phone number of client
 * @param {String} email - email of the client
 * @param {String} company - company the client works for
 * @param {String} address - address of client
 * @param {String} city - city of client
 * @param {String} state - state of client
 * @param {String} zip - zipcode of the client
 * @param {String} rep - assigned representative
 * @param {String} url - uniform resource location information
 */    
function BusinessModel(name, title, phone, email, company, address, city, state, zip, rep, url){
    this.name = name;
    this.title = title;
    this.phone = phone;
    this.email = email;
    this.company = company;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.rep = rep;
    this.url = url;
}

BusinessModel.prototype = {
    /**
     * @description validateInfo(): facilitator - validates client's information
     * @returns {String}
     */ 
    validateInfo : function(){
        var valide, validurl, validp = 'SORRY: valid phone format required.'
                +'\nValid format: ##########';
        valide = 'SORRY: valid email format required.'
                +'\nValid format-1: name@yahoo.com'
                +'\nValid format-2: name_123@yahoo.com'
                +'\nValid format-3: name.123name@name.yahoo.com';
        validurl = 'SORRY: url required.\nIf not applicable "null" is permitted.';
        
        if (this.name.length == 0 || this.name === '') return 'SORRY: name required.';
        if (this.title.length == 0 || this.title === '') return 'SORRY: title required.';
        if (this.phone.length == 0 || this.phone === '') return 'SORRY: phone required.';
        if (!BusinessModel.isPhone(this.phone)) return validp+'\nException failure: '+this.phone;
        if (this.email.length == 0 || this.email === '') return valide+'\nException failure: '+this.email;
        if (!BusinessModel.isEmail(this.email)) return 'SORRY: valid email format required.';
        if (this.rep.length == 0 || this.rep == '') return 'SORRY: representative required.';
        if (this.company.length == 0 || this.company === '') return 'SORRY: organization name required.';
        if (this.address.length == 0 || this.address === '') return 'SORRY: address required.';
        if (this.city.length == 0 || this.city === '') return 'SORRY: city name required.';
        if (this.state.length == 0 || this.state === '') return 'SORRY: state required.';
        if (this.zip.length == 0 || this.zip === '') return 'SORRY: zipcode required.';
        if (!BusinessModel.isZip(this.zip)) return 'SORRY: valid zip format required.';
        if (this.url.length == 0 || this.url === '') return validurl+'\nException failure: '+this.url;
        if (!BusinessModel.isUrl(this.url)) return 'SORRY: url does not conform to format.';
        return null;
    },

    /**
     * @description toString(): facilitator - processes output message
     * @returns {String}
     */
    toString : function(){
        var string = "";
        string += "Name: "+this.name+"\nTitle: "+this.title
               +"\nPhone: "+this.phone+"\nEmail: "+this.email
               +"\nRepresentative: "+this.rep+ "\nCompany: "+this.company
               +"\nAddress: "+this.address+ "\nCity: "+this.city
               +"\nState: "+this.state+ "\nZipcode: "+this.zip
               +'\nUrl: '+this.url;               
        return string;
    }
};

/**
 * @description isPhone(): accessor - returns true/false based on user-input
 * @param {String} phone
 * @returns {Boolean}
 */
BusinessModel.isPhone = function(phone){
    // "?" = match previous item zero or one time
    // "*" = match previous item zero or more times
    // "+" = match previous item one or more times
    // "{m,n}" = match previous items at min m-times and max n-times
    // "|" = logical OR within regular expression
    
    var pattern = /^\d{3}[-.]?\d{3}[-.]?\d{4}$/;  //ok
    return pattern.test(phone) ? true : false;
};

/**
 * @description isEmail(): accessor - returns true/false based on user-input
 * @param {String} email
 * @returns {Boolean}
 */
BusinessModel.isEmail = function(email){
    //both case-sensitive and case-insensitive letters
    var lower = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
    var upper = /^[_A-Z0-9-]+(\.[_A-Z0-9-]+)*@[A-Z0-9-]+(\.[A-Z0-9-]+)*(\.[A-Z]{2,4})$/;
    return (lower.test(email) || upper.test(email)) ? true : false;
};

/**
 * @description isZip(): accessor - returns true/false based on user-input
 * @param {Number} zip
 * @returns {Boolean}
 */
BusinessModel.isZip = function(zip){
    var pattern = /^\d{5}$/;
	return pattern.test(zip) ? true : false;
};

/**
 * @description isUrl(): accessor - returns true for valid url, false otherwise
 * @param {String} url - adapts url to standard format
 * @returns {Boolean}
 */
BusinessModel.isUrl = function(url){ //p.247
    // | is logical OR within regular expression
    var pattern = /^(http:.*|ftp:.*|https:.*|null)$/;
    return pattern.test(url) ? true : false;
};