local function expireAPI_70(keys,args)
    local key = keys[1]
    local expire = args[1]
    local count = args[2]

    if redis.call('exists',key) == 0 then
       redis.call('setex',key,expire,1)
       return true
    end


    if redis.call('get',key) >= count then
        return false
    end
    redis.call('incr',key)
    return true
end
redis.register_function('expireAPI_70',expireAPI_70)

local function buy_70(keys,args)
    local key = keys[1]
    if redis.call('hget',key,'total') == '0' then
        return -1
    end

    return redis.call('hincrby',key,'total',-1)
--     return tonumber(redis.call('hget',key,'total'))
end
redis.register_function('buy_70',buy_70)
