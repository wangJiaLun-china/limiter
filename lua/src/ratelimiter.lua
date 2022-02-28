-- 模拟限流

-- 用作限流的key
local key = 'My Key'

-- 限流的最大阈值
local limit = 2

-- 当前的流量大小
local currentLimit = 2

-- 是否超出限流标准
if currentLimit + 1 > limit then
    print 'reject'
    return false
else
    print 'accept'
    return true
end