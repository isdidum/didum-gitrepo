/**
 * @author A., Didum [iusc13@hushmail.com]
 */
function DateObject(a,b,c){this.modifiedDate=new Date(document.lastModified),this.month=this.modifiedDate.getMonth(),this.toString(a,b,c)}DateObject.prototype={thisMonth:function(a){try{for(var b="",c=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"],d=0;d<c.length;d++)if(d===a&&(b=c[d],""!=b||null!=b))return b;return null}catch(e){alert("File: *./update.js\nMethod: thisMonth()\nMessage: "+e.message)}},thisDay:function(a){try{for(var b="",c=["Sun","Mon","Tue","Wed","Thu","Fri","Sat"],d=0;d<c.length;d++)if(d==new Number(a)&&(b=c[d],""!=b||null!=b))return b;return null}catch(e){alert("File: *./update.js\nMethod: thisMonth()\nMessage: "+e.message)}},toString:function(a,b,c){try{var d,e,f,h,g="AM",i=this.modifiedDate;if(h=Date.parse(document.lastModified),null!=i&&(f=i.getHours()),f>=12&&(g="PM",f-=12),0==f&&(f=12),0==h)d="Last Modified: Unknown",e="Modified: "+d+"<br />Copyright &copy; "+a+"-"+l+". All Rights Reserved.",document.getElementById(b).innerHTML=e;else{var j,k,l,m,n;null!=i&&(j=this.thisDay(i.getDay()),k=i.getDate(),l=i.getFullYear(),m=i.getMinutes(),n=i.getSeconds()),""==c||null==c?(d=j+", "+this.thisMonth(this.month)+" "+k+", "+l+" @ "+f+":"+m+":"+n+" "+g+" CST.",e="Modified: "+d+"<br />Copyright &copy; "+a+"-"+l+". All Rights Reserved."):(""!=c||null!=c)&&(d=j+", "+this.thisMonth(this.month)+" "+k+", "+l+" @ "+f+":"+m+":"+n+" "+g+" CST.",e=c+"<br />Modified: "+d+"<br />Copyright &copy; "+a+"-"+l+". All Rights Reserved."),"undefined"!=typeof b&&(null!=typeof b||""!=type(b))&&(document.getElementById(b).innerHTML=e)}}catch(o){alert("File: *./update.js\nMethod: toString()\nMessage: "+o.message)}}};