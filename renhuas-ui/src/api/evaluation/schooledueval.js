import request from '@/utils/request'

// 查询学校测评列表
export function listSchooledueval(query) {
  return request({
    url: '/evaluation/schooledueval/list',
    method: 'get',
    params: query
  })
}

// 查询学校测评详细
export function getSchooledueval(evalId) {
  return request({
    url: '/evaluation/schooledueval/' + evalId,
    method: 'get'
  })
}

// 新增学校测评
export function addSchooledueval(data) {
  return request({
    url: '/evaluation/schooledueval',
    method: 'post',
    data: data
  })
}

// 修改学校测评
export function updateSchooledueval(data) {
  return request({
    url: '/evaluation/schooledueval',
    method: 'put',
    data: data
  })
}

// 删除学校测评
export function delSchooledueval(evalId) {
  return request({
    url: '/evaluation/schooledueval/' + evalId,
    method: 'delete'
  })
}

// 导出学校测评
export function exportSchooledueval(query) {
  return request({
    url: '/evaluation/schooledueval/export',
    method: 'get',
    params: query
  })
}