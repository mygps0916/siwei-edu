import request from '@/utils/request'

// 查询平均分数列表
export function listAveragescore(query) {
  return request({
    url: '/basicdata/averagescore/list',
    method: 'get',
    params: query
  })
}

// 查询平均分数详细
export function getAveragescore(averageScoreId) {
  return request({
    url: '/basicdata/averagescore/' + averageScoreId,
    method: 'get'
  })
}

// 新增平均分数
export function addAveragescore(data) {
  return request({
    url: '/basicdata/averagescore',
    method: 'post',
    data: data
  })
}

// 修改平均分数
export function updateAveragescore(data) {
  return request({
    url: '/basicdata/averagescore',
    method: 'put',
    data: data
  })
}

// 删除平均分数
export function delAveragescore(averageScoreId) {
  return request({
    url: '/basicdata/averagescore/' + averageScoreId,
    method: 'delete'
  })
}

// 导出平均分数
export function exportAveragescore(query) {
  return request({
    url: '/basicdata/averagescore/export',
    method: 'get',
    params: query
  })
}