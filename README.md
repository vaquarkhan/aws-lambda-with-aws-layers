# aws-lambda-layers

## What are Lambda Layers?

Lambda Layers are a new type of artifact that can contain arbitrary code and data, and may be referenced by zero, one, or more functions at the same time. Lambda functions in a serverless application typically share common dependencies such as SDKs, frameworks, and now runtimes. With layers, you can centrally manage common components across multiple functions enabling better code reuse.
- https://aws.amazon.com/about-aws/whats-new/2018/11/aws-lambda-now-supports-custom-runtimes-and-layers/


Lambda Layers have been created to solve this repeated code issue. The way they work is that you deploy your common code into a layer. This can be your common code or NPM packages that you always use. When you connect this layer to one of your Lambdas, you can access all the common code from inside your Lambda.

This means that you don’t have to copy the same file into every Lambda folder or create your own ‘common’ repo that you require.

- https://dashbird.io/blog/using-lambda-layers-for-better-serverless-architecture/
- https://medium.com/faun/aws-lambda-layers-d07831ff50ea
- https://medium.com/@zeebaig/working-with-aws-lambda-layers-ddf5c91674d3
- https://github.com/orta/AWS-Lambda-Layers-Example
- https://blog.skbali.com/2018/11/aws-lambda-layer-example-in-python/
- https://www.puresec.io/blog/aws-lambda-security-considerations-runtime-api-and-layers
- https://towardsdatascience.com/introduction-to-amazon-lambda-layers-and-boto3-using-python3-39bd390add17
