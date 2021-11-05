import request from '@/utils/request'

// 查询科目信息列表
export function listCourseinfo(query) {
  return request({
    url: '/basicdata/courseinfo/list',
    method: 'get',
    params: query
  })
}

// 查询科目信息详细
export function getCourseinfo(courseId) {
  return request({
    url: '/basicdata/courseinfo/' + courseId,
    method: 'get'
  })
}

// 新增科目信息
export function addCourseinfo(data) {
  return request({
    url: '/basicdata/courseinfo',
    method: 'post',
    data: data
  })
}

// 修改科目信息
export function updateCourseinfo(data) {
  return request({
    url: '/basicdata/courseinfo',
    method: 'put',
    data: data
  })
}

// 删除科目信息
export function delCourseinfo(courseId) {
  return request({
    url: '/basicdata/courseinfo/' + courseId,
    method: 'delete'
  })
}

// 导出科目信息
export function exportCourseinfo(query) {
  return request({
    url: '/basicdata/courseinfo/export',
    method: 'get',
    params: query
  })
}