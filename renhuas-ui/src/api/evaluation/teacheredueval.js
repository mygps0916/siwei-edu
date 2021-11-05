import request from '@/utils/request'

// 查询老师教学测评列表
export function listTeacheredueval(query) {
  return request({
    url: '/evaluation/teacheredueval/list',
    method: 'get',
    params: query
  })
}

// 查询老师教学测评详细
export function getTeacheredueval(evalId) {
  return request({
    url: '/evaluation/teacheredueval/' + evalId,
    method: 'get'
  })
}

// 新增老师教学测评
export function addTeacheredueval(data) {
  return request({
    url: '/evaluation/teacheredueval',
    method: 'post',
    data: data
  })
}

// 修改老师教学测评
export function updateTeacheredueval(data) {
  return request({
    url: '/evaluation/teacheredueval',
    method: 'put',
    data: data
  })
}

// 删除老师教学测评
export function delTeacheredueval(evalId) {
  return request({
    url: '/evaluation/teacheredueval/' + evalId,
    method: 'delete'
  })
}

// 导出老师教学测评
export function exportTeacheredueval(query) {
  return request({
    url: '/evaluation/teacheredueval/export',
    method: 'get',
    params: query
  })
}