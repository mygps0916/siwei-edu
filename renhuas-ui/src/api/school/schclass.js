import request from '@/utils/request'

// 查询班级信息列表
export function listSchclass(query) {
  return request({
    url: '/school/schclass/list',
    method: 'get',
    params: query
  })
}

// 查询班级信息详细
export function getSchclass(classId) {
  return request({
    url: '/school/schclass/' + classId,
    method: 'get'
  })
}

// 新增班级信息
export function addSchclass(data) {
  return request({
    url: '/school/schclass',
    method: 'post',
    data: data
  })
}

// 修改班级信息
export function updateSchclass(data) {
  return request({
    url: '/school/schclass',
    method: 'put',
    data: data
  })
}

// 删除班级信息
export function delSchclass(classId) {
  return request({
    url: '/school/schclass/' + classId,
    method: 'delete'
  })
}

// 导出班级信息
export function exportSchclass(query) {
  return request({
    url: '/school/schclass/export',
    method: 'get',
    params: query
  })
}