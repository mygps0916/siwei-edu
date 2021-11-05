import request from '@/utils/request'

// 查询老师个人测评列表
export function listTeachpersioneval(query) {
  return request({
    url: '/evaluation/teachpersioneval/list',
    method: 'get',
    params: query
  })
}

// 查询老师个人测评详细
export function getTeachpersioneval(evalId) {
  return request({
    url: '/evaluation/teachpersioneval/' + evalId,
    method: 'get'
  })
}

// 新增老师个人测评
export function addTeachpersioneval(data) {
  return request({
    url: '/evaluation/teachpersioneval',
    method: 'post',
    data: data
  })
}

// 修改老师个人测评
export function updateTeachpersioneval(data) {
  return request({
    url: '/evaluation/teachpersioneval',
    method: 'put',
    data: data
  })
}

// 删除老师个人测评
export function delTeachpersioneval(evalId) {
  return request({
    url: '/evaluation/teachpersioneval/' + evalId,
    method: 'delete'
  })
}

// 导出老师个人测评
export function exportTeachpersioneval(query) {
  return request({
    url: '/evaluation/teachpersioneval/export',
    method: 'get',
    params: query
  })
}