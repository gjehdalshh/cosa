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

let selectedFile

file_input.onchange = function() {
	selectedFile = file_input.files[0]
	console.log(selectedFile)
}

function upload() {
	
	let reader = new FileReader()
	let dataIndex = reader.result.indexOf(',') + 1
	let base64 = reader.result.substring(dataIndex, reader.result.length)
	
	FileReader.prototype.read
	console.log(base64)
	let param = {
		file_type: selectedFile.type,
		file_name: selectedFile.name,
		file_data: selectedFile.size,
		i_user: i_user.value
	}
	console.log(param)
	
	fetch(`/user/profile/insertImg`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		
	})
}
