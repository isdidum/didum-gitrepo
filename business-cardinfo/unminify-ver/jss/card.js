
/**
 * Remarks: These methods are directly invoked in html file.
 */
function BusinessCard(){
    this.card = new ControlMgr(6);
    document.getElementById("find").title = this.card.msgs.nmquery;
}

function ienable(){
    this.card.enable();
}

function ienter(evt){
    this.card.enter(evt);
}

function iquery(){
    this.card.query();
}

function iadd(){
    this.card.add();
}

function iremove(){
    this.card.remove();
}

function imodify(){
    iopenField();
    this.card.modify();
}

function ifirst(){
    icloseField();
    this.card.first();
}

function iprevious(){
    icloseField();
    this.card.previous();
}

function inext(){
    icloseField();
    this.card.next();
}

function ilast(){
    icloseField();
    this.card.last();
}

function iclear(){
    this.card.clear();
}

function ibin(bool){
    this.card.bin(bool);
}

function itray(num){
    this.card.cleanBin(num);
}

function iopenField(){
    this.card.enableField();
}

function icloseField(){
    this.card.disableField();
}