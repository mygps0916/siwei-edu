import request from '@/utils/request'

// 查询学校类型列表
export function listSchooltype(query) {
  return request({
    url: '/basicdata/schooltype/list',
    method: 'get',
    params: query
  })
}

// 查询学校类型详细
export function getSchooltype(schTypeId) {
  return request({
    url: '/basicdata/schooltype/' + schTypeId,
    method: 'get'
  })
}

// 新增学校类型
export function addSchooltype(data) {
  return request({
    url: '/basicdata/schooltype',
    method: 'post',
    data: data
  })
}

// 修改学校类型
export function updateSchooltype(data) {
  return request({
    url: '/basicdata/schooltype',
    method: 'put',
    data: data
  })
}

// 删除学校类型
export function delSchooltype(schTypeId) {
  return request({
    url: '/basicdata/schooltype/' + schTypeId,
    method: 'delete'
  })
}

// 导出学校类型
export function exportSchooltype(query) {
  return request({
    url: '/basicdata/schooltype/export',
    method: 'get',
    params: query
  })
}