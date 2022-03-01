-- 模拟限流

-- 用作限流的key
local methodKey = KEYS[1]
redis.log(redis.LOG_DEBUG, "key is", methodKey)

-- 限流的最大阈值
local limit = tonumber(ARGV[1])

-- 当前的流量大小
local currentLimit = tonumber(redis.call('get', methodKey) or "0")

-- 是否超出限流标准
if currentLimit + 1 > limit then
    return false
else
    redis.call("INCRBY", methodKey, 1)
    redis.call("EXPIRE", methodKey , 1)
    return true
end