let i_user = document.querySelector('#i_user')
let file_input = document.querySelector('#fileUpload')

function rename() {
	let url = `/user/profile/modifyNm`
	changeNameAndPhone(url)
}

function changePhoneNumber() {
	let url = `/user/profile/modifyPh`
	changeNameAndPhone(url)
}

function changeNameAndPhone(url) {
	let nm = document.querySelector('#nm')
	let phone = document.querySelector('#phone')

	let param = {
		i_user: i_user.value,
		user_nm: nm.value,
		user_phone: phone.value
	}
	
	fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		if (conditionVerification(data)) {
			alert('회원정보가 변경되었습니다.')
		}
	})
}

function upload() {
	let fileForm = document.querySelector('#fileForm')
	formData = new FormData(fileForm)
	
	fetch('/user/profile/insertImg',{
		method:'POST',
		body : formData
	}).then(function() {
		alert('업로드에 성공하였습니다.')
	})
}


function upload() {

	let fileUpload = document.querySelector('#fileUpload')

	let files = fileUpload.files
	console.log('files : ' + files)
	filesArr = Array.prototype.slice.call(files);
	let formData = new FormData()

	for (var i = 0; i < filesArr.length; i++) {
		console.log('aa')
		//formData.append('files[' + i + ']', filesArr[i]);
		formData.append('files', filesArr[i]);
	}

	fetch('/user/profile/insProfileImg', {
		method: 'POST',
		headers: {
			contentType: false,               // * 중요 *
			processData: false,               // * 중요 *
			enctype: 'multipart/form-data',  // * 중요 *
		},
		body: formData
	}).then(function() {
		alert('업로드에 성공하였습니다.')
	})
}





