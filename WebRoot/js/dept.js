	window.onload = function() {
		loadDept();
		document.getElementById("addBtn").addEventListener("click", function(e) {
			addDept();
		}, false);
		document.getElementById("editCancelBtn").addEventListener("click", function(e) {
			document.getElementById("addDiv").style.display="block";
			document.getElementById("editDiv").style.display="none";
		}, false);
		document.getElementById("selectAll").addEventListener("click", function(e) {
			var didEle=document.all("did");
			if(didEle.length==undefined){//单个元素
				didEle.checked=this.checked;
			}else{//多个元素
				for(var x=0;x<didEle.length;x++){
					didEle[x].checked=this.checked;
				}
			}
		}, false);
		document.getElementById("deleteAll").addEventListener("click", function(e) {
			var idArray=new Array();
			var foot=0;
			var didEle=document.all("did");
			var ids="";
			if(didEle.length==undefined){//单个元素
				if(didEle.checked){
					ids+=didEle.value+":";	
					idArray[foot++]=didEle.value;
				}
			}else{//多个元素
				for(var x=0;x<didEle.length;x++){
					if(didEle[x].checked){
						ids+=didEle[x].value+":";
						idArray[foot++]=didEle[x].value;
					}
				}
			}
			if(ids==""){
				alert("请选择需要删除的数据！！");
			}else{
				if(window.confirm("是否删除选中数据？")){
					deleteDept(ids,idArray);
				}
			}
		}, false);
	}
	function deleteDept(ids,idArray){
		createXmlHttpRequest();
		xmlHttpRequest.open("post", "DeptServlet/delete?ids="+ids);
		xmlHttpRequest.send(null);	
		xmlHttpRequest.onreadystatechange=function(){
			if(xmlHttpRequest.readyState==4&&xmlHttpRequest.status==200){
				var result=xmlHttpRequest.responseText;
				if(result=="true"){		
					for(var x=0;x<idArray.length;x++){
						var trEle=document.getElementById("dept-"+idArray[x]);
						trEle.parentNode.removeChild(trEle);
					}
					alert("数据已删除！！");
				}else{
					alert("数据删除失败！！");
				}
			}
		}
	}
	function editPreDept(did,idArray){
		createXmlHttpRequest();
		xmlHttpRequest.open("post", "DeptServlet/editPre?did="+did);
		xmlHttpRequest.send(null);	
		xmlHttpRequest.onreadystatechange=function(){
			if(xmlHttpRequest.readyState==4&&xmlHttpRequest.status==200){
				var result=xmlHttpRequest.responseText.split(":");
				document.getElementById("dname-edit").value=result[1];
				document.getElementById("loc-edit").value=result[2];
			}
		}
	}
	function editDept(did){
		var dname=document.getElementById("dname-edit").value;
		var loc=document.getElementById("loc-edit").value;
		if(dname!="" && loc!=""){
			createXmlHttpRequest();
			xmlHttpRequest.open("post", "DeptServlet/edit?did="+did+"&dname="+dname+"&loc="+loc);
			xmlHttpRequest.send(null);
			xmlHttpRequest.onreadystatechange = function() {
				if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
					var result =xmlHttpRequest.responseText;
					if(result=="true"){
						document.getElementById("dname-"+did).innerHTML=dname;
						document.getElementById("loc-"+did).innerHTML=loc;
						alert("修改成功");
						document.getElementById("addDiv").style.display="block";
						document.getElementById("editDiv").style.display="none";
					}else{
						alert("修改失败！！");
					}
				}
			}
		}else{
			alert("请确认数据是否为空！！");
		}
	}
	function addDept(){
		var dname=document.getElementById("dname-add").value;
		var loc=document.getElementById("loc-add").value;
		if(dname!="" && loc!=""){
			createXmlHttpRequest();
			xmlHttpRequest.open("post", "DeptServlet/add?dname="+dname+"&loc="+loc);
			xmlHttpRequest.send(null);
			xmlHttpRequest.onreadystatechange = function() {
				if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
					var result =xmlHttpRequest.responseText.split(":");
					if(result[0]=="true"){
						addRow(result[1], dname, loc);
						resetForm();
					}else{
						alert("数据增加失败！！");
					}
				}
			}
		}else{
			alert("请确认数据是否为空！！");
		}
	}
	function resetForm(){
		document.getElementById("dname-add").value="";
		document.getElementById("loc-add").value="";		
	}
	var xmlHttpRequest;
	function createXmlHttpRequest() {
		if (window.XMLHttpRequest) { //判断浏览器是否支持XMLHttpRequest
			xmlHttpRequest = new XMLHttpRequest();
		} else {
			xmlHttpRequest = new ActiveXObject("Misrosoft.XMLHttp");
		}
	}
	function loadDept() {
		createXmlHttpRequest();
		xmlHttpRequest.open("post", "DeptServlet/list");
		xmlHttpRequest.send(null);
		xmlHttpRequest.onreadystatechange = function() {
			if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
				var didList=xmlHttpRequest.responseXML.getElementsByTagName("did");
				var dnameList=xmlHttpRequest.responseXML.getElementsByTagName("dname");
				var locList=xmlHttpRequest.responseXML.getElementsByTagName("loc");
				for(var x=0;x<didList.length;x++){
					addRow(didList[x].firstChild.nodeValue,dnameList[x].firstChild.nodeValue,locList[x].firstChild.nodeValue);
				}
			}
		}
	}
	//在进行部门列表以及部门数据追加时都需要用到
	function addRow(did,dname,loc){
		//创建tr元素
		var trEle=document.createElement("tr");
		trEle.setAttribute("id","dept-"+did);
		//创建td元素
		var tdEle=document.createElement("td");
		tdEle.setAttribute("id","sa-"+did);
		//创建checkbox元素
		var checkEle=document.createElement("input");
		checkEle.setAttribute("type", "checkbox");
		checkEle.setAttribute("id","did");
		checkEle.setAttribute("value",did);
		tdEle.appendChild(checkEle);
		//创建did所在列
		var didTdEle=document.createElement("td");
		didTdEle.setAttribute("id","did-"+did);
		didTdEle.appendChild(document.createTextNode(did));
		
		//创建dname所在列
		var dnameTdEle=document.createElement("td");
		dnameTdEle.setAttribute("id","dname-"+did);
		dnameTdEle.appendChild(document.createTextNode(dname));
		
		//创建dname所在列
		var locTdEle=document.createElement("td");
		locTdEle.setAttribute("id","loc-"+did);
		locTdEle.appendChild(document.createTextNode(loc));
		
		//创建操作所在列
		var updateEle=document.createElement("td");
		//定义一个按钮
		var updateButEle=document.createElement("input");
		updateButEle.setAttribute("type", "button"); 
		updateButEle.setAttribute("value", "Update"); 
		updateButEle.addEventListener("click", function(e) {
			//隐藏add表单
			document.getElementById("addDiv").style.display="none";
			document.getElementById("editDiv").style.display="block";
			editPreDept(did);

			//为update按钮增加事件
//			document.getElementById("editBtn").addEventListener("click", function(e) {	
//				editDept(did);
//			}, false);	
			document.getElementById("editBtn").onclick=function(){
				editDept(did);
			}
		}, false);
		updateEle.appendChild(updateButEle);
		trEle.appendChild(tdEle);
		trEle.appendChild(didTdEle);
		trEle.appendChild(dnameTdEle);
		trEle.appendChild(locTdEle);
		trEle.appendChild(updateEle);
		//创建tbody元素
		var tbodyEle=document.createElement("tbody");
		tbodyEle.appendChild(trEle);
		document.getElementById("deptTable").appendChild(tbodyEle);
	}