primesTo :: Integer -> [Integer]
primesTo m = eratos [2..m]
  where
    eratos []     = []
    eratos (p:xs) = p : eratos (filter (\x -> x `mod` p /= 0) xs)

main :: IO ()
main = do
  let result = primesTo 100000
  pure ()

